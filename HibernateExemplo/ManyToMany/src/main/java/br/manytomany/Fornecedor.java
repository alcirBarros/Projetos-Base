package br.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "frn_fornecedor", catalog = "hibernateDB")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = -7355508055514809681L;

    @Id
    @GeneratedValue
    @Column(name = "frn_id", nullable = false)
    private Integer id;

    @Column(name = "frn_nome_fantasia", unique = true, nullable = false)
    private String nomeFantasia;

//    @ManyToMany
//    @JoinTable(schema = "hibernateDB",
//            inverseJoinColumns = {
//                @JoinColumn(name = "pdt_id", referencedColumnName = "pdt_id")})
    
    @ManyToMany
    @JoinTable(name = "pdt_produto_frn_fornecedorrr", schema = "hibernateDB",
            joinColumns = {
                @JoinColumn(name = "frn_id", foreignKey = @ForeignKey(name = "fk_pdt_frn_id"))},
            inverseJoinColumns = {
                @JoinColumn(name = "pdt_id", foreignKey = @ForeignKey(name = "fk_frn_pdt_id"))}
    )

//    @ManyToMany
//    @JoinTable(name = "pfr_produto_fornecedor", schema = "hibernateDB",
//            joinColumns = {
//                @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "pdt_id", referencedColumnName = "pdt_id")})
    private List<Produto> produtoList = new ArrayList<>();

    public Fornecedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
