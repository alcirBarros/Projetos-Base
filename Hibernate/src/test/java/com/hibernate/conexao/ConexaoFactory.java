package com.hibernate.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory {

    public static final EntityManager em;

    static {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
        em = factory.createEntityManager();
    }
}
