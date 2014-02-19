package com.hibernate.hibernate.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pss_pessoa")
public class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="pss_id", nullable = false)
    private Integer id;
    
    @Column(name="pss_nome")
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   

}
