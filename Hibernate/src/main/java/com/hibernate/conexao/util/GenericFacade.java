package com.hibernate.conexao.util;

import com.hibernate.conexao.hibernateDB.ConexaoFactory;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericFacade<T> extends ConexaoFactory implements Serializable {

    private static final long serialVersionUID = 7376266510848831508L;

    private Class classe;

    public GenericFacade() {
    }

    @SuppressWarnings("rawtypes")
    public GenericFacade(EntityManager em, Class ec) {
        super.em = em;
        this.classe = ec;
    }

    public T inserir(T entity) {
        em.persist(entity);
        return entity;
    }

    public T alterar(T entity) {
        T merged = em.merge(entity);
        return merged;
    }

    public void excluir(T entity) {
        T merge = em.merge(entity);
        em.remove(merge);
    }

    public T carregar(Object id) {
        return (T) em.find(classe, id);
    }

    public T carregar(String sigla) {
        try {
            List<T> resultList = em.createQuery("select t from " + classe.getSimpleName() + " t where t.sigla = :sigla").setParameter("sigla", sigla).getResultList();
            if (resultList.size() > 0) {
                return resultList.get(0);
            } else {
                return null;
            }
        } catch (SecurityException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> listarTodos(String... orders) {
        String orderBy = "";
        if (orders.length > 0) {
            orderBy = " order by ";
            for (String property : orders) {
                orderBy += " t." + property + ", ";
            }
            orderBy = orderBy.substring(0, orderBy.length() - 2);
        }
        return em.createQuery("select t from " + classe.getSimpleName() + " t " + orderBy)
                .getResultList();
    }

//    @SuppressWarnings({"rawtypes", "unchecked"})
//    public int contar() {
//        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        javax.persistence.criteria.Root<T> rt = cq.from(classe);
//        cq.select(em.getCriteriaBuilder().count(rt));
//        javax.persistence.Query q = em.createQuery(cq);
//        return ((Long) q.getSingleResult()).intValue();
//    }

    @SuppressWarnings("unchecked")
    public List<T> query(String query, Object... parameters) {
        Query q = em.createQuery(query);
        int i = 1;
        for (Object object : parameters) {
            q.setParameter(i, object);
            i++;
        }
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> search(String query, String... parameters) {
        Query q = em.createQuery(query);
        int i = 1;
        for (String s : parameters) {
            q.setParameter(i, "%" + s + "%");
            i++;
        }
        return q.getResultList();
    }
}
