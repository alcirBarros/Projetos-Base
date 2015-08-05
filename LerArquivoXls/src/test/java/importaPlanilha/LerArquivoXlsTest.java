package importaPlanilha;

import com.lerarquivoxls.AbrirArquivoXls;
import com.lerarquivoxls.Leitor;
import com.lerarquivoxls.ProcessaPlanilha;
import com.util.JPAUtilParaTestes;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LerArquivoXlsTest {

    private EntityManager em;
    private ProcessaPlanilha processaPlanilha = new ProcessaPlanilha();

    public LerArquivoXlsTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        em = new JPAUtilParaTestes().getEntityManager();
        processaPlanilha.setEm(em);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        try {
            File abrirArquivo = AbrirArquivoXls.abrirArquivo();
            List<List> list = new Leitor().lerPLanilha(abrirArquivo);
            processaPlanilha.processar(list);
        } catch (Exception ex) {
            Logger.getLogger(LerArquivoXlsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
