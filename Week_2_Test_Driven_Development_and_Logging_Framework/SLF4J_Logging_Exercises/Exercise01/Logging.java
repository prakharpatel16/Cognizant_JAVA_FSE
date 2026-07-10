package SLF4J_Exercises.Exercise01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private static final Logger logger =
            LoggerFactory.getLogger(Logging.class);
    public static void main(String[] args) {
        logger.error("Error message");
        logger.warn("Warning message");
    }
}