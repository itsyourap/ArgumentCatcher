package com.itsyourap.argumentcatcher.log;

import com.itsyourap.argumentcatcher.constants.PathConstants;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
    public static void logToFile(final String string){
        try (
                FileWriter fileWriter = new FileWriter(PathConstants.LOG_FILE_PATH, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)
        )
        {
            printWriter.println();
            printWriter.println("----------------------------------------------------------------------");
            printWriter.println(getDateTime());
            printWriter.println("----------------------------------------------------------------------");
            printWriter.println(string);
            printWriter.println("----------------------------------------------------------------------");
        } catch (IOException ignored) {}
    }
    private static String getDateTime(){
        Date date = new Date();
        return date.toString();
    }
}
