
import br.PostgreSql;
import br.util.ConexaoFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        
        EntityManager em = ConexaoFactory.getEntityManagerPostgres();
        EntityTransaction txn = em.getTransaction();

        PostgreSql employee = new PostgreSql();
        employee.setEmail("someMail@gmail.com");
        employee.setFirstname("Prasad");
        employee.setLastname("kharkar");

        txn.begin();
        em.persist(employee);
        txn.commit();
    }
}