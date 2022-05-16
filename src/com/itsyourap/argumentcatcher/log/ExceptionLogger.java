package com.itsyourap.argumentcatcher.log;

import com.itsyourap.argumentcatcher.constants.PathConstants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ExceptionLogger {
    public static void logException(Exception e){
        try (
                FileWriter fileWriter = new FileWriter(PathConstants.EXCEPTION_FILE_PATH, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)
        )
        {
            printWriter.println();
            printWriter.println("----------------------------------------------------------------------");
            printWriter.println(getDateTime());
            printWriter.println("----------------------------------------------------------------------");
            printWriter.println(e);
            for (StackTraceElement traceElement : e.getStackTrace()){
                printWriter.println("\tat " + traceElement);
            }

            for (Throwable suppressed : e.getSuppressed()){
                printWriter.println(suppressed);
            }

            if (e.getCause() != null)
                printWriter.println(e.getCause());

            printWriter.println();
            printWriter.println("----------------------------------------------------------------------");
        } catch (IOException ignored) {}
    }

    private static String getDateTime(){
        Date date = new Date();
        return date.toString();
    }
}
