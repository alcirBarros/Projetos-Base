package com.hibernate.persistencia;

import com.hibernate.filter.entidade.Usuario;
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
            usuario.getPessoa().getSexo().setDescricao("F");

            em.getTransaction().begin();
            em.persist(usuario.getPessoa());
            usuario.setId(usuario.getPessoa().getId());
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
