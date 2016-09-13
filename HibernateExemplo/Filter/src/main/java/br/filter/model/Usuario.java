package br.filter.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usr_usuario", catalog = "hibernateDB")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -1304410802629512301L;

    @Id
    @Column(name = "usu_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pss_id", referencedColumnName = "pss_id")
    private Pessoa pessoa;

    @Column(name = "pmv_quantidade", nullable = false)
    private BigInteger quantidade = BigInteger.ZERO;

    public Usuario() {
        pessoa = new Pessoa();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}