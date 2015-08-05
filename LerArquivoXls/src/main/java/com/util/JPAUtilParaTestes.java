package com.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilParaTestes implements Serializable {

    private static final long serialVersionUID = 2826481878140676901L;
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
