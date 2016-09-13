
import br.heranca.model.PessoaFisica;
import br.heranca.model.PessoaJuridica;
import br.util.ConexaoFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//https://altieresm.wordpress.com/2011/07/09/implementando-heranca-com-hibernate/

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
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setNome("AAAAAAAAAA");
            pessoaFisica.setCpf("234567892345");
            em.getTransaction().begin();
            em.persist(pessoaFisica);
            em.getTransaction().commit();
            List<PessoaFisica> resultList = em.createQuery("select u from PessoaFisica u ", PessoaFisica.class).getResultList();
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
