
import br.movimentacaoproduto.model.MovimentacaoProduto;
import br.movimentacaoproduto.model.Produto;
import br.movimentacaoproduto.model.ProdutoMovimentacao;
import br.movimentacaoproduto.model.SaldoEstoque;
import br.movimentacaoproduto.model.TipoMovimento;
import br.util.ConexaoFactory;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NovoEmptyJUnitTest1 {

    public NovoEmptyJUnitTest1() {
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
    

//    @Test
    public void hello() {
        EntityManager em = ConexaoFactory.getEntityManagerMysql();

        Produto produto = new Produto();
        produto.setDescricao("ÁCIDO ACETILSALICÍLICO");

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.clear();

        SaldoEstoque saldoEstoque = new SaldoEstoque();
        saldoEstoque.setProduto(produto);
        saldoEstoque.setQuantidade(new BigDecimal("10"));

        {
            MovimentacaoProduto movimentacaoProduto = new MovimentacaoProduto();
            movimentacaoProduto.setTipoMovimento(TipoMovimento.ENTRADA);
            movimentacaoProduto.setProcessado(Boolean.TRUE);

            ProdutoMovimentacao produtoMovimentacao = new ProdutoMovimentacao();
            produtoMovimentacao.setMovimentacaoProduto(movimentacaoProduto);
            produtoMovimentacao.setProduto(produto);
            produtoMovimentacao.setQuantidade(new BigDecimal("10"));
            produtoMovimentacao.setSaldoEstoque(saldoEstoque);

            movimentacaoProduto.getProdutoMovimentacaoList().add(produtoMovimentacao);

            em.getTransaction().begin();
            em.persist(movimentacaoProduto);
            em.getTransaction().commit();
            em.clear();
        }

        MovimentacaoProduto movimentacaoProduto;

        ProdutoMovimentacao produtoMovimentacao;

        {
            movimentacaoProduto = new MovimentacaoProduto();
            movimentacaoProduto.setTipoMovimento(TipoMovimento.SAIDA);
            movimentacaoProduto.setProcessado(Boolean.FALSE);

            produtoMovimentacao = new ProdutoMovimentacao();
            produtoMovimentacao.setMovimentacaoProduto(movimentacaoProduto);
            produtoMovimentacao.setProduto(produto);
            produtoMovimentacao.setQuantidade(new BigDecimal("10"));
            produtoMovimentacao.setSaldoEstoque(saldoEstoque);

            movimentacaoProduto.getProdutoMovimentacaoList().add(produtoMovimentacao);

            em.getTransaction().begin();
            movimentacaoProduto = em.merge(movimentacaoProduto);
            em.getTransaction().commit();
            em.clear();
        }

        {
            movimentacaoProduto.getProdutoMovimentacaoList().get(0).setQuantidade(new BigDecimal("5"));

            em.getTransaction().begin();
            movimentacaoProduto = em.merge(movimentacaoProduto);
            em.getTransaction().commit();
            em.clear();
        }
        
        
//        {
//            produtoMovimentacao = new ProdutoMovimentacao();
//            produtoMovimentacao.setMovimentacaoProduto(movimentacaoProduto);
//            produtoMovimentacao.setProduto(produto);
//            produtoMovimentacao.setQuantidade(new BigDecimal("5"));
//            produtoMovimentacao.setSaldoEstoque(saldoEstoque);
//            movimentacaoProduto.getProdutoMovimentacaoList().add(produtoMovimentacao);
//
//            em.getTransaction().begin();
//            movimentacaoProduto = em.merge(movimentacaoProduto);
//            em.getTransaction().commit();
//            em.clear();
//        }
        
        {
            movimentacaoProduto.getProdutoMovimentacaoList().remove(0);
            
            em.getTransaction().begin();
            movimentacaoProduto = em.merge(movimentacaoProduto);
            em.getTransaction().commit();
            em.clear();
        }
    }
}
