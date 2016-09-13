package br.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pdt_produto", catalog = "hibernateDB")
public class Produto implements Serializable {

    private static final long serialVersionUID = -6316705341646429615L;

    @Id
    @GeneratedValue
    @Column(name = "pdt_id", nullable = false)
    private Integer id;
    
    @Column(name = "pdt_descricao", length = 255) 
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
}
