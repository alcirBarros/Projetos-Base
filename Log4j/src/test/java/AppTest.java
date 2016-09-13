import com.selfsystem.log4j.LogService;
import org.junit.Before;
import org.junit.Test;

public class AppTest extends LogService{

    public AppTest() {
        setClass(this.getClass());
    }

    @Before
    public void setUp() {
        
    }

    @Test
    public void testApp() {
        logger.trace("1111111111111111111111111111111");
        logger.debug("2222222222222222222222222222222");
        logger.info("33333333333333333333333333333333");
        logger.warn("44444444444444444444444444444444");
        logger.error("5555555555555555555555555555555");
        logger.fatal("6666666666666666666666666666666");
    }
}
