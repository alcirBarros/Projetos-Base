
import br.dynamic_insert.model.Pessoa;
import br.util.ConexaoFactory;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

//http://www.mkyong.com/hibernate/hibernate-dynamic-insert-attribute-example/
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
        EntityManager em = ConexaoFactory.getEntityManagerMysql();
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("AAAAAAAAAAAA");
            pessoa.setDataNascimento(new Date());

            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        }
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("BBBBBBBBBBB");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        }

    }
}
