package com.hibernate.heranca.model.exemplo2;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ins_instituicao", catalog = "hibernateDB")
@Inheritance(strategy = InheritanceType.JOINED)
public class Instituicao implements Serializable {

    private static final long serialVersionUID = 3989495708796555321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id", nullable = false)
    private Integer id;

    @Column(name = "ins_nome_fanta", nullable = false)
    private String nomeFanta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFanta() {
        return nomeFanta;
    }

    public void setNomeFanta(String nomeFanta) {
        this.nomeFanta = nomeFanta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Instituicao other = (Instituicao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
