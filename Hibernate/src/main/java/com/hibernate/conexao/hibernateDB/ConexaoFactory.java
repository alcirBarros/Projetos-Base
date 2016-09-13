package com.hibernate.conexao.hibernateDB;


import com.hibernate.conexao.util.GenericFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory extends GenericFacade<Object>{

    protected static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    protected static EntityManager em;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("HibernateDB");
        em = ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
