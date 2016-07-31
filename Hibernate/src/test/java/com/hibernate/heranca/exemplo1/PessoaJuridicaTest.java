package com.hibernate.heranca.exemplo1;

import com.hibernate.heranca.model.exemplo1.PessoaJuridica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaJuridicaTest {

    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = factory.createEntityManager();

            PessoaJuridica animal = new PessoaJuridica();
            animal.setNome("BBBBBBBBBBBBB");
            animal.setCnpj("23456789");

            em.getTransaction().begin();
            em.persist(animal);
            em.getTransaction().commit();

            List<PessoaJuridica> resultList = em.createQuery("select u from PessoaJuridica u ", PessoaJuridica.class).getResultList();
            System.out.println(resultList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
