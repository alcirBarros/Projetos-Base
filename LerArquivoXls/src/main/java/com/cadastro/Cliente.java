package com.cadastro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clt_cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 9139504994268494970L;

    @Id
    @GeneratedValue
    @Column(name = "clt_id", nullable = false)
    private Integer id;

    @Column(name = "clt_codigo", nullable = false)
    private String codigo;

    @Column(name = "clt_nome", nullable = false)
    private String nome;

    public Cliente() {
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
