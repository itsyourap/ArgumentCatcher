package com.itsyourap.argumentcatcher.constants;

import java.io.File;
import java.net.URISyntaxException;

public class PathConstants {
    public final static String DATA_PATH = ".argumentcatcher";
    public static String SAVED_ARGUMENTS_DIRECTORY = DATA_PATH + File.separatorChar + "output" + File.separatorChar;
    public static String LOG_FILE_PATH = DATA_PATH + File.separatorChar;
    public static String EXCEPTION_FILE_PATH = DATA_PATH + File.separatorChar;

    static {
        try {
            String EXECUTABLE_NAME =  new File(PathConstants.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath()).getName();

            LOG_FILE_PATH = LOG_FILE_PATH + EXECUTABLE_NAME + "_LOG.txt";
            EXCEPTION_FILE_PATH = EXCEPTION_FILE_PATH + EXECUTABLE_NAME + "_EXCEPTION.txt";
            SAVED_ARGUMENTS_DIRECTORY = SAVED_ARGUMENTS_DIRECTORY + EXECUTABLE_NAME;

        } catch (URISyntaxException e) {
            LOG_FILE_PATH = LOG_FILE_PATH + "Argument_Catcher_LOG.txt";
            EXCEPTION_FILE_PATH = EXCEPTION_FILE_PATH + "Argument_Catcher_EXCEPTION.txt";
        }
    }
}
