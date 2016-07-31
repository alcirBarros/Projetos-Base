package com.hibernate.heranca.exemplo1;

import com.hibernate.heranca.model.exemplo1.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaTest {
    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = factory.createEntityManager();
            
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("AAAAAAAAAA");
            
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();

            List<Pessoa> resultList = em.createQuery("select u from Pessoa_2 u ", Pessoa.class).getResultList();
            System.out.println(resultList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
