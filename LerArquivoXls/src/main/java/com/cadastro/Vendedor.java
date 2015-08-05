package com.cadastro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vnd_vendedor")
public class Vendedor implements Serializable {
    
    private static final long serialVersionUID = -5841819569696369574L;

    @Id
    @GeneratedValue
    @Column(name = "vnd_id", nullable = false)
    private Integer id;

    @Column(name = "vnd_codigo")
    private String codigo;

    @Column(name = "vnd_nome", nullable = false)
    private String nome;

    public Vendedor() {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
