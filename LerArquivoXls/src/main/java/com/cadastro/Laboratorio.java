package com.cadastro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lab_laboratorio")
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = -57670189230445038L;

    @Id
    @GeneratedValue
    @Column(name = "lab_id", nullable = false)
    private Integer id;

    @Column(name = "lab_codigo")
    private String codigo;

    @Column(name = "lab_descricao", nullable = false)
    private String descricao;

    public Laboratorio() {
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
