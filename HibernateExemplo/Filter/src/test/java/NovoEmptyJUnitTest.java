
import br.filter.model.Contato;
import br.filter.model.Pessoa;
import br.filter.model.Usuario;
import br.util.ConexaoFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
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
        Session session = (Session) em.getDelegate();

        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("nome");
            pessoa.getSexo().setDescricao("F");

            Contato contato = new Contato();
            contato.setPessoa(pessoa);
            contato.setInfo("1234567");
            pessoa.getContatoList().add(contato);

            Contato contato2 = new Contato();
            contato2.setPessoa(pessoa);
            contato2.setInfo("1234567");
            contato2.setAtivo(Boolean.FALSE);
            pessoa.getContatoList().add(contato2);

            Usuario usuario = new Usuario();
            usuario.setPessoa(pessoa);

            em.getTransaction().begin();
            em.persist(usuario.getPessoa());
            usuario.setId(usuario.getPessoa().getId());

            em.persist(usuario);
            em.getTransaction().commit();
        }

        {
            // em.clear();
            session.clear();
            List<Contato> contatoList = session.createQuery("select u from Contato u").list();
            System.out.println(contatoList);
        }

        {
//                em.clear();
            session.clear();
            StringBuilder query1 = new StringBuilder();
            query1.append("SELECT ");
            query1.append("    pss.* ");
            query1.append("FROM ");
            query1.append("    pss_pessoa pss ");
            Pessoa pessoa = (Pessoa) session.createCriteria(Pessoa.class, query1.toString()).uniqueResult();
            System.out.println(pessoa);

            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    usr ");
            query.append("FROM ");
            query.append("    Usuario usr ");
            Usuario usuario = (Usuario) session.createCriteria(Usuario.class, query.toString()).uniqueResult();
            System.out.println(usuario);
        }

        {
//                em.clear();
            session.clear();
            session.enableFilter("ativo").setParameter("status", true);
            StringBuilder query1 = new StringBuilder();
            query1.append("SELECT ");
            query1.append("    pss.* ");
            query1.append("FROM ");
            query1.append("    pss_pessoa pss ");
            Pessoa pessoa = (Pessoa) session.createCriteria(Pessoa.class, query1.toString()).uniqueResult();
            System.out.println(pessoa);

            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    usr ");
            query.append("FROM ");
            query.append("    Usuario usr ");
            Usuario usuario = (Usuario) session.createCriteria(Usuario.class, query.toString()).uniqueResult();
            System.out.println(usuario);
        }

        {
            //em.clear();
            session.clear();
            session.disableFilter("ativo");
            StringBuilder query1 = new StringBuilder();
            query1.append("SELECT ");
            query1.append("    pss.* ");
            query1.append("FROM ");
            query1.append("    pss_pessoa pss ");
            Pessoa pessoa = (Pessoa) session.createCriteria(Pessoa.class, query1.toString()).uniqueResult();
            System.out.println(pessoa);

            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    usr ");
            query.append("FROM ");
            query.append("    Usuario usr ");
            Usuario usuario = (Usuario) session.createCriteria(Usuario.class, query.toString()).uniqueResult();
            System.out.println(usuario);
        }

        System.out.println("NovoEmptyJUnitTest.hello()");
    }
}
