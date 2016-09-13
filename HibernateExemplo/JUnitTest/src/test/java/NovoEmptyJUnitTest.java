
import br.util.ANSIColor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alci
 */
public class NovoEmptyJUnitTest {

    public NovoEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        //EntityManager entityManager = ConexaoFactory.getEntityManager();        
        ANSIColor.blue();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.cyan();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.gold();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.green();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.lime();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.magenta();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.maroon();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.navy();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.purple();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.red();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.silver();
        System.out.println("NovoEmptyJUnitTest.hello()");
        ANSIColor.reset();
    }
}
