package demo.api.untils;

import org.apache.log4j.Logger;

public class Log {
    private static final Logger logger = Logger.getLogger(Log.class.getSimpleName());

    public static void debug(String TAG, String msg) {
        logger.debug(TAG + ": " + msg);
    }

    public static void info(String TAG, String msg) {
        logger.info(TAG + ": " + msg);
    }

    public static void error(String TAG, String msg, Throwable throwable) {
        logger.error(TAG + ": " + msg, throwable);
    }

    public static void error(String TAG, String msg) {
        logger.error(TAG + ": " + msg);
    }
}
