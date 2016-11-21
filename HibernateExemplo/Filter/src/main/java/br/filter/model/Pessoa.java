package br.filter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

@Entity(name = "Pessoa_1")
@Table(name = "pss_pessoa", catalog = "hibernateDB")
@FilterDef(name = "ativo", parameters = {@ParamDef(name = "status", type = "boolean")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = -403686655985098117L;

    @Id
    @GeneratedValue
    @Column(name = "pss_id", nullable = false)
    private Integer id;

    @Column(name = "pss_nome")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sxo_id", referencedColumnName = "sxo_id")
    private Sexo sexo;

    @Where(clause = "cnt_ativo = 1")
    @Filter(name = "ativo", condition = "cnt_ativo = :status")
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, targetEntity = Contato.class)
    private List<Contato> contatoList = new ArrayList<>();

    public Pessoa() {
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

    public List<Contato> getContatoList() {
        return contatoList;
    }

    public void setContatoList(List<Contato> contatoList) {
        this.contatoList = contatoList;
    }
    
}