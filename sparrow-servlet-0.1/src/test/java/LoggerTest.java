import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    private static Logger logger = LoggerFactory.getLogger("com.sparrow.test");

    public static void main(String[] args) {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
