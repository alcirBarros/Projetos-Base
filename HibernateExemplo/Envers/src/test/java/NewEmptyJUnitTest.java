import br.hibernate.exemplo.model.Auditoria;
import br.util.ConexaoFactory;
import java.util.List;
import javax.persistence.EntityManager;
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
public class NewEmptyJUnitTest {

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
            Auditoria pessoa = new Auditoria();
            pessoa.setNome("AAAAAAAAAA");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            List<Auditoria> resultList = em.createQuery("select u from Pessoa u ", Auditoria.class).getResultList();
        }

        System.out.println("NovoEmptyJUnitTest.hello()");
    }
}
