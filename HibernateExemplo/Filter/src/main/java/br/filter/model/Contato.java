package br.filter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;


@Entity
@Where(clause = "cnt_ativo = 1")
@Table(name = "cnt_contato", catalog = "hibernateDB")
@FilterDef(name = "ativo", parameters = {@ParamDef(name = "status", type = "boolean")})
@Filter(name = "ativo", condition = "cnt_ativo = :status")
public class Contato implements Serializable {

    private static final long serialVersionUID = 2819522057713894983L;

    @Id
    @GeneratedValue
    @Column(name = "cnt_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pss_id", referencedColumnName = "pss_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cnt_pss_id"))
    private Pessoa pessoa;

    @Column(name = "cnt_info")
    private String info;

    @Column(name = "cnt_ativo")
    private Boolean ativo = Boolean.TRUE;

    public Contato() {
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}