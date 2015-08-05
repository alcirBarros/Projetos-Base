package com.cadastro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pdt_produto")
public class Produto implements Serializable{
    
    private static final long serialVersionUID = 41214622826708128L;

    @Id
    @GeneratedValue
    @Column(name = "pdt_id", nullable = false)
    private Integer id;

    @Column(name = "pdt_codigo", nullable = false)
    private String codigo;

    @Column(name = "pdt_descricao", nullable = false)
    private String descricao;

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
