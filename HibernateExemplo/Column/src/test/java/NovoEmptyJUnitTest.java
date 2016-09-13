
import br.column.ColumnType;
import br.util.ConexaoFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        EntityManager em = ConexaoFactory.getEntityManager();

        {
            ColumnType columnType = new ColumnType();
            columnType.setColumnString("AAAAAAAAAAAAAAA");
            columnType.setColumnInteger(1111111);
            columnType.setColumnLong(11111111111L);
            columnType.setColumnBoolean(Boolean.FALSE);
            columnType.setColumnDataTime(new Date());
            columnType.setColumnDate(new Date());
            columnType.setColumnTime(new Date());
            columnType.setColumnBigInteger(BigInteger.ONE);
            columnType.setColumnBigDecimal(BigDecimal.ONE);
            
            
            em.getTransaction().begin();
            em.persist(columnType);
            em.getTransaction().commit();
        }
    }
}
