package com.hibernate.heranca.exemplo2;

import com.hibernate.heranca.model.exemplo2.Fabricante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FabricanteTest {

    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = factory.createEntityManager();

            Fabricante fabricante = new Fabricante();
            fabricante.setNomeFanta("AAAAAAAAAAAAAAAAa");
            fabricante.setFabricante("BBBBBBBBBBBBBb");

            em.getTransaction().begin();
            em.persist(fabricante);
            em.getTransaction().commit();

            List<Fabricante> resultList = em.createQuery("select u from Fabricante u ", Fabricante.class).getResultList();
            System.out.println(resultList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
