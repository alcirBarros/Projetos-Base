package br.util;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory {

    private static final Map<String, EntityManager> entityManagerHashMap = new HashMap<>();
    protected static EntityManager em;

    static {
        em = createEntityManager(TipoConexaoEnum.MYSQL);
    }

    private static EntityManager createEntityManager(TipoConexaoEnum tipoConexaoEnum) {
        String persistenceUnit = tipoConexaoEnum.getPersistenceUnit();
        EntityManager entityManager = entityManagerHashMap.get(persistenceUnit);
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
            entityManager = entityManagerFactory.createEntityManager();
            entityManagerHashMap.put(persistenceUnit, entityManager);
        }
        return entityManager;
    }

    public static EntityManager getEntityManagerMysql() {
        return createEntityManager(TipoConexaoEnum.MYSQL);
    }

    public static EntityManager getEntityManagerPostgres() {
        return createEntityManager(TipoConexaoEnum.POSTGRES);
    }
}