package relatorio;

import com.relatorio.VendaRealizadaPdfDynamic;
import com.relatorio.MovimentacaoPorVendedorPdfDynamic;
import com.util.JPAUtilParaTestes;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;

public class MovimentacaoPorVendedorDynamicTest {

    private EntityManager em;

    private MovimentacaoPorVendedorPdfDynamic relatorio = new MovimentacaoPorVendedorPdfDynamic();

    private static final String[] MOVIMENTACAO = {"1"};

    @Before
    public void setUp() {
        em = new JPAUtilParaTestes().getEntityManager();
        relatorio.setEm(em);
    }

    @Test
    public void gerarRelatorio() throws Exception {
        Map<String, String[]> valores = new HashMap<>();
        //valores.put("movimentacaoId", MOVIMENTACAO);
        relatorio.parametro(valores, null).toPdf(new FileOutputStream("//tmp//SALUTE.pdf"));
    }

}
