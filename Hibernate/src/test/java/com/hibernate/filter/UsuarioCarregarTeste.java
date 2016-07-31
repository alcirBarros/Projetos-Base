package com.hibernate.filter;

import com.hibernate.filter.entidade.Contato;
import com.hibernate.filter.entidade.Pessoa;
import com.hibernate.filter.entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.classic.Session;

public class UsuarioCarregarTeste {

    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = factory.createEntityManager();
            Session session = (Session) em.getDelegate();
            {
                // em.clear();
                session.clear();
                List<Contato> contatoList = session.createQuery("select u from Contato u").list();
                System.out.println(contatoList);
            }

            {
//                em.clear();
                session.clear();
                StringBuilder query1 = new StringBuilder();
                query1.append("SELECT ");
                query1.append("    pss.* ");
                query1.append("FROM ");
                query1.append("    pss_pessoa pss ");
                Pessoa pessoa = (Pessoa) session.createCriteria(Pessoa.class, query1.toString()).uniqueResult();
                System.out.println(pessoa);

                StringBuilder query = new StringBuilder();
                query.append("SELECT ");
                query.append("    usr ");
                query.append("FROM ");
                query.append("    Usuario usr ");
                Usuario usuario = (Usuario) session.createCriteria(Usuario.class, query.toString()).uniqueResult();
                System.out.println(usuario);
            }

            {
//                em.clear();
                session.clear();
                session.enableFilter("ativo").setParameter("status", true);
                StringBuilder query1 = new StringBuilder();
                query1.append("SELECT ");
                query1.append("    pss.* ");
                query1.append("FROM ");
                query1.append("    pss_pessoa pss ");
                Pessoa pessoa = (Pessoa) session.createCriteria(Pessoa.class, query1.toString()).uniqueResult();
                System.out.println(pessoa);

                StringBuilder query = new StringBuilder();
                query.append("SELECT ");
                query.append("    usr ");
                query.append("FROM ");
                query.append("    Usuario usr ");
                Usuario usuario = (Usuario) session.createCriteria(Usuario.class, query.toString()).uniqueResult();
                System.out.println(usuario);
            }

            {
                //em.clear();
                session.clear();
                session.disableFilter("ativo");
                StringBuilder query1 = new StringBuilder();
                query1.append("SELECT ");
                query1.append("    pss.* ");
                query1.append("FROM ");
                query1.append("    pss_pessoa pss ");
                Pessoa pessoa = (Pessoa) session.createCriteria(Pessoa.class, query1.toString()).uniqueResult();
                System.out.println(pessoa);

                StringBuilder query = new StringBuilder();
                query.append("SELECT ");
                query.append("    usr ");
                query.append("FROM ");
                query.append("    Usuario usr ");
                Usuario usuario = (Usuario) session.createCriteria(Usuario.class, query.toString()).uniqueResult();
                System.out.println(usuario);
            }

//            em.getTransaction().begin();
//            em.merge(usuario);
//            em.getTransaction().commit();

//            Usuario usuario = em.createQuery("select u from Usuario u where u.id = :usuarioId", Usuario.class)
//                    .setParameter("usuarioId", 1)
//                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
