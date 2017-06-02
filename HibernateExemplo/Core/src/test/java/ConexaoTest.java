
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoTest {

    private static EntityManager em;

    static {
        EntityManagerFactory factory;
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/HibernateDB");
        properties.put("hibernate.hbm2ddl.auto", "nome");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "root");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        factory = Persistence.createEntityManagerFactory("HibernateDB", properties);
        em = factory.createEntityManager();
    }

    public static void main(String[] args) {
        List resultList = em.createNativeQuery("select NOW();").getResultList();
        System.out.println(resultList);
    }
}
