
import br.heranca.model.Pessoa;
import br.heranca.model.PessoaJuridica;
import br.util.ConexaoFactory;
import java.util.List;
import javax.persistence.EntityManager;
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
        EntityManager em = ConexaoFactory.getEntityManager();
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("AAAAAAAAAA");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            List<Pessoa> resultList = em.createQuery("select u from Pessoa u ", Pessoa.class).getResultList();
        }

        {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setNome("BBBBBBBBBBBBB");
            pessoaJuridica.setCnpj("23456789");

            em.getTransaction().begin();
            em.persist(pessoaJuridica);
            em.getTransaction().commit();
            List<PessoaJuridica> resultList = em.createQuery("select u from PessoaJuridica u ", PessoaJuridica.class).getResultList();
        }

        System.out.println("NovoEmptyJUnitTest.hello()");
    }
}
