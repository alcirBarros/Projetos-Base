
import br.model.MovimentacaoProduto;
import br.model.Produto;
import br.model.ProdutoMovimentacao;
import br.model.SaldoEstoque;
import br.util.ConexaoFactory;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

    private Produto cadastrarProduto() {
        Produto produto = new Produto();
        produto.setDescricao("DEXAMETASONA 0,1% CREME 10 G");
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        return produto;
    }

    @Test
    public void hello() {

        Produto produto = cadastrarProduto();

        MovimentacaoProduto movimentacaoProduto = new MovimentacaoProduto();

        ProdutoMovimentacao produtoMovimentacao = new ProdutoMovimentacao();
        produtoMovimentacao.setMovimentacaoProduto(movimentacaoProduto);
        produtoMovimentacao.setQuantidade(BigDecimal.TEN);

        SaldoEstoque saldoEstoque = new SaldoEstoque();
        saldoEstoque.setProduto(produto);
        saldoEstoque.setQuantidade(BigDecimal.ONE);
        saldoEstoque.setValorUnitario(BigDecimal.ZERO);
        saldoEstoque.setDataValidade(new Date());

        produtoMovimentacao.setSaldoEstoque(saldoEstoque);
        movimentacaoProduto.getProdutoMovimentacaoList().add(produtoMovimentacao);

        em.getTransaction().begin();
        em.persist(movimentacaoProduto);
        em.getTransaction().commit();

        em.clear();

        movimentacaoProduto = em.find(MovimentacaoProduto.class, movimentacaoProduto.getId());
        
        em.clear();
        
        movimentacaoProduto = em.createQuery("select m from MovimentacaoProduto m where m.id = :movimentacaoProdutoId", MovimentacaoProduto.class)
                .setParameter("movimentacaoProdutoId", movimentacaoProduto.getId())
                .getSingleResult();
        
        em.clear();

        movimentacaoProduto = (MovimentacaoProduto) em.createNativeQuery("select * from hibernateDB.mpd_movimentacao_produto where mpd_id = :movimentacaoProdutoId", MovimentacaoProduto.class)
                .setParameter("movimentacaoProdutoId", movimentacaoProduto.getId())
                .getSingleResult();
        
        
//        movimentacaoProduto.getProdutoMovimentacaoList().remove(0).getSaldoEstoque().setQuantidade(BigDecimal.TEN);

        em.getTransaction().begin();
        em.persist(movimentacaoProduto);
        em.getTransaction().commit();

        em.clear();

        movimentacaoProduto.getProdutoMovimentacaoList().remove(0);

        em.getTransaction().begin();
        em.merge(movimentacaoProduto);
        em.getTransaction().commit();

    }
}
