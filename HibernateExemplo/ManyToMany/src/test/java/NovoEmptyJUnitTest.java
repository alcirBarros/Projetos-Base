
import br.manytomany.Fornecedor;
import br.manytomany.Produto;
import br.util.ConexaoFactory;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
            Produto produto = new Produto();
            produto.setDescricao("PRODUTO A");

            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();

            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNomeFantasia("FORNECEDOR A");
            fornecedor.getProdutoList().add(produto);

            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();

            em.clear();
        }
        
        Fornecedor fornecedor = em.find(Fornecedor.class, 1);
        System.out.println(fornecedor);

    }
}
