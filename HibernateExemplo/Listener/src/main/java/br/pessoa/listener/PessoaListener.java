package br.pessoa.listener;

import br.pessoa.model.Pessoa;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class PessoaListener {

    @PrePersist
    public void userPrePersist(Pessoa pessoa) {
        System.out.println("Listening Pesssoa Pre Persist : " + pessoa.getNome());
    }

    @PostPersist
    public void userPostPersist(Pessoa pessoa) {
        System.out.println("Listening Pesssoa Post Persist : " + pessoa.getNome());
    }

    @PostLoad
    public void userPostLoad(Pessoa pessoa) {
        System.out.println("Listening Pesssoa Post Load : " + pessoa.getNome());
    }

    @PreUpdate
    public void userPreUpdate(Pessoa pessoa) {
        System.out.println("Listening Pesssoa Pre Update : " + pessoa.getNome());
    }

    @PostUpdate
    public void userPostUpdate(Pessoa pessoa) {
        System.out.println("Listening Pesssoa Post Update : " + pessoa.getNome());
    }

    @PreRemove
    public void userPreRemove(Pessoa pessoa) {
        System.out.println("Listening Pesssoa Pre Remove : " + pessoa.getNome());
    }

    @PostRemove
    public void userPostRemove(Pessoa pessoa) {
        System.out.println("Listening Pesssoa Post Remove : " + pessoa.getNome());
    }
}
