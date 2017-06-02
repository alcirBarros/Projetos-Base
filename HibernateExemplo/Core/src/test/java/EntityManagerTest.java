
import br.util.ConexaoFactory;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityManagerTest {



    public EntityManagerTest() {
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
        EntityManager entityManager = ConexaoFactory.getEntityManagerMysql();
        System.out.println(entityManager);
        System.out.println("TESTE....");
    }
}
