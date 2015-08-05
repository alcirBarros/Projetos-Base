package relatorio;

import com.relatorio.MovimentacaoProdutoPdfDynamic;
import com.util.JPAUtilParaTestes;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;


public class MovimentacaoProdutoDynamicTest {
    
    private EntityManager em;

    private MovimentacaoProdutoPdfDynamic relatorio = new MovimentacaoProdutoPdfDynamic();

    private static final String[] MOVIMENTACAO_PRODUTO_ID = {"12924"};

    @Before
    public void setUp() {
        em = new JPAUtilParaTestes().getEntityManager();
        relatorio.setEm(em);
    }

    @Test
    public void gerarRelatorio() throws Exception {
        Map<String, String[]> valores = new HashMap<>();
        valores.put("movimentacaoProdutoId", MOVIMENTACAO_PRODUTO_ID);
        relatorio.parametro(valores, null).toPdf(new FileOutputStream("//tmp//SALUTE.pdf"));
    }
}
