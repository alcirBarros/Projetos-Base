package br.com.rsaraiva.labs.exapp03.service;

import br.com.caelum.vraptor.ioc.Component;
import br.com.rsaraiva.labs.exapp03.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;

@Component
public class PessoaService {

    private EntityManager em;
    
    public PessoaService(EntityManager em) {
        this.em = em;
    }
    
    public List<Pessoa> listaTudo() {
        return em.createQuery("select p from Pessoa p order by p.nome").getResultList();
    }
    
    public void salva(Pessoa pessoa) {
        em.merge(pessoa);
    }
}
