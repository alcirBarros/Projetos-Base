package br.heranca.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "psj_pessoa_juridica", schema = "hibernateDB")
@PrimaryKeyJoinColumn(name = "pss_id", referencedColumnName = "pss_id")
public class PessoaJuridica extends Pessoa {

    private static final long serialVersionUID = -6172127294759514438L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "psj_id")
    private Integer id;

    @Column(name = "psj_cnpj", nullable = false)
    private String cnpj;

    @Override
    public Integer getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cnpj);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }
}
