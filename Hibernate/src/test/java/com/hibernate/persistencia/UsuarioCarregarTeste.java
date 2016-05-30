package com.hibernate.persistencia;

import com.hibernate.persistencia.entidade.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioCarregarTeste {

    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = factory.createEntityManager();

            Usuario usuario = em.createQuery("select u from Usuario u where u.id = :usuarioId", Usuario.class)
                    .setParameter("usuarioId", 1)
                    .getSingleResult();

            System.out.println(usuario);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
