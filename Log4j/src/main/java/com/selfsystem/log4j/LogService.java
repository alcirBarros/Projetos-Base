package com.selfsystem.log4j;

import org.apache.log4j.Logger;

public abstract class LogService {

    private static Logger logger;

    public void setClass(Class<?> clazz) {
        logger = Logger.getLogger(clazz.getName());
    }

    public static class logger {

        public static void trace(String args) {
            logger.trace(args);
        }

        public static void debug(String args) {
            logger.debug(args);
        }

        public static void info(String args) {
            logger.info(args);
        }

        public static void warn(String args) {
            logger.warn(args);
        }

        public static void error(String args) {
            logger.error(args);
        }

        public static void fatal(String args) {
            logger.fatal(args);
        }
    }

}
