package com.hibernate.hibernate.entidade;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="sxo_id", referencedColumnName="sxo_id")
    private Sexo sexo;
    
    public Pessoa(){
       sexo = new Sexo();
    }

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

   public Sexo getSexo() {
      return sexo;
   }

   public void setSexo(Sexo sexo) {
      this.sexo = sexo;
   }
    
    

}
