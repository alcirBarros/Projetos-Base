import br.util.ConexaoFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alci
 */
public class SubselectTest {

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSubselectWithSynchronize() {

        EntityManager em = ConexaoFactory.getEntityManagerMysql();

//        long itemId = 1;
//        Item item = new Item();
//        item.setName("widget");
//        item.setId(itemId);
//        em.getTransaction().begin();
//        em.persist(item);
//        em.getTransaction().commit();
//
//        Bid bid1 = new Bid();
//        bid1.setAmount(100.0);
//        bid1.setItemId(itemId);
//        bid1.setId(1);
//        em.getTransaction().begin();
//        em.persist(bid1);
//        em.getTransaction().commit();
//
//        Bid bid2 = new Bid();
//        bid2.setAmount(200.0);
//        bid2.setItemId(itemId);
//        bid2.setId(2);
//        em.getTransaction().begin();
//        em.persist(bid2);
//        em.getTransaction().commit();
//        List<HighestBid> resultList = em.createQuery("from HighestBid b", HighestBid.class).getResultList();
//        for (Object resultList1 : resultList) {
//            System.out.println(resultList1.toString());
//        }
//        
////        HighestBid highestBid = resultList.get(1);
////        highestBid.setName("aaaaaa");
////        highestBid.setAmount(12345);
////        
////        em.getTransaction().begin();
////        em.persist(highestBid);
////        em.getTransaction().commit();
//        
    }
}
