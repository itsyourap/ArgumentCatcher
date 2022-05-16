package com.itsyourap.argumentcatcher;

import com.itsyourap.argumentcatcher.constants.PathConstants;
import com.itsyourap.argumentcatcher.log.ExceptionLogger;
import com.itsyourap.argumentcatcher.log.Logger;

import java.io.*;
import java.nio.file.Files;

public class ArgumentCatcher {
    public static void main(String[] args) {
        createDirectories();

        if (args.length == 0)
            return;

        StringBuilder logBuilder = new StringBuilder();
        String joinedArgs = joinArguments(args);
        logBuilder.append("Arguments:-").append("\n").append(joinedArgs).append("\n");

        try {
            String argumentOutput = findAssociatedOutput(joinedArgs);
            if (argumentOutput != null){
                System.out.println(argumentOutput);
                logBuilder.append("Output:-").append("\n").append(argumentOutput).append("\n");
            }
        } catch (Exception e) {
            ExceptionLogger.logException(e);
        }

        Logger.logToFile(logBuilder.toString());
    }

    private static String joinArguments(String[] args){
        StringBuilder joinedArgs = new StringBuilder();
        for (String arg : args){
            joinedArgs.append(arg).append(" ");
        }
        return joinedArgs.toString().trim();
    }

    private static String findAssociatedOutput(String args) throws IOException {
        File file = new File(PathConstants.SAVED_ARGUMENTS_DIRECTORY + File.separatorChar + args + ".txt");
        if (!file.exists())
            return null;

        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
        String line;
        while ((line = reader.readLine()) != null){
            output.append(line).append("\n");
        }
        reader.close();

        return output.toString().trim();
    }

    private static void createDirectories(){
        File file = new File(PathConstants.SAVED_ARGUMENTS_DIRECTORY);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }

    }
}
