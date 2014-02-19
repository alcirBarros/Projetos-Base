package com.hibernate.hibernate.teste;

import com.hibernate.hibernate.entidade.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioTeste {

    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = factory.createEntityManager();

            Usuario usuario = new Usuario();
            usuario.getPessoa().setNome("nome");

            em.getTransaction().begin();
            em.persist(usuario.getPessoa());
            usuario.setId(usuario.getPessoa().getId());
            em.persist(usuario);
            em.getTransaction().commit();
            
            em.createQuery("select u from Usuario u").getResultList();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
