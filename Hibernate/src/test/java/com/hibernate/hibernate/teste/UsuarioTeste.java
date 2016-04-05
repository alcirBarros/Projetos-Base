package com.hibernate.hibernate.teste;

import com.hibernate.hibernate.entidade.Contato;
import com.hibernate.hibernate.entidade.Pessoa;
import com.hibernate.hibernate.entidade.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioTeste {

    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = factory.createEntityManager();

            Pessoa pessoa = new Pessoa();
            pessoa.setNome("nome");
            pessoa.getSexo().setDescricao("F");

            Contato contato = new Contato();
            contato.setPessoa(pessoa);
            contato.setInfo("1234567");
            pessoa.getContatoList().add(contato);
            
            Contato contato2 = new Contato();
            contato2.setPessoa(pessoa);
            contato2.setInfo("1234567");
            contato2.setAtivo(Boolean.FALSE);
             pessoa.getContatoList().add(contato2);

            Usuario usuario = new Usuario();
            usuario.setPessoa(pessoa);

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
