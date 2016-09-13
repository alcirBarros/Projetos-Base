
import br.fetchtype.model.Fornecedor;
import br.fetchtype.model.NotaFiscal;
import br.fetchtype.model.Produto;
import br.fetchtype.model.ProdutoNotaFiscal;
import br.util.ConexaoFactory;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//http://www.devmedia.com.br/lazy-e-eager-loading-com-hibernate/29554
public class NovoEmptyJUnitTest {

    private static EntityManager em;

    public NovoEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        em = ConexaoFactory.getEntityManager();
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

    private static NotaFiscal localizar(Integer notaFiscalId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("    * ");
        query.append("FROM ");
        query.append("    hibernateDB.ntf_nota_fiscal ");
        query.append("WHERE ");
        query.append("    ntf_id = ").append(notaFiscalId).append("; ");
        NotaFiscal notaFiscal = (NotaFiscal) em.createNativeQuery(query.toString(), NotaFiscal.class).getSingleResult();
        return notaFiscal;
    }

    private static NotaFiscal salvar(NotaFiscal geraNotaFiscal) {
        em.getTransaction().begin();
        em.persist(geraNotaFiscal);
        em.getTransaction().commit();
        return geraNotaFiscal;
    }

    private static NotaFiscal geraNotaFiscal() {
        NotaFiscal notaFiscal = new NotaFiscal();
        Fornecedor fornecedor = fornecedor();
        notaFiscal.setFornecedor(fornecedor);
        ProdutoNotaFiscal produtoNotaFiscal = produtoNotaFiscal();
        notaFiscal.addProdutoNotaFiscalListener(produtoNotaFiscal);
        return notaFiscal;
    }

    private static ProdutoNotaFiscal produtoNotaFiscal() {
        ProdutoNotaFiscal produtoNotaFiscal = new ProdutoNotaFiscal();
        Produto produto = new Produto();
        produto.setDescricao("AAAAAAAa");
        produtoNotaFiscal.setProduto(produto);
        return produtoNotaFiscal;
    }

    private static Fornecedor fornecedor() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomeFantasia("AAAAAA");
        return fornecedor;
    }

    @Test
    public void hello() {
        NotaFiscal notaFiscal = geraNotaFiscal();
        notaFiscal = this.salvar(notaFiscal);
        em.clear();
        NotaFiscal localizar = localizar(notaFiscal.getId());
        em.close();
        //String nomeFantasia = localizar.getFornecedor().getNomeFantasia();
        System.out.println("NovoEmptyJUnitTest.hello()");
    }
}
