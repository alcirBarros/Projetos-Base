package br.fetchtype.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ntf_nota_fiscal", catalog = "hibernateDB")
public class NotaFiscal implements Serializable {

    private static final long serialVersionUID = -8531358644430282158L;

    @Id
    @GeneratedValue
    @Column(name = "ntf_id", nullable = false)
    private Integer id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id", foreignKey = @ForeignKey(name = "fk_ntf_frn_id"))
    private Fornecedor fornecedor;
    
    @OneToMany(mappedBy = "notaFiscal", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProdutoNotaFiscal> produtoNotaFiscalList = new ArrayList<>();

    public NotaFiscal() {
    }
    
    public void addProdutoNotaFiscalListener(ProdutoNotaFiscal produtoNotaFiscal){
        produtoNotaFiscal.setNotaFiscal(this);
        produtoNotaFiscalList.add(produtoNotaFiscal);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ProdutoNotaFiscal> getProdutoNotaFiscalList() {
        return produtoNotaFiscalList;
    }

    public void setProdutoNotaFiscalList(List<ProdutoNotaFiscal> produtoNotaFiscalList) {
        this.produtoNotaFiscalList = produtoNotaFiscalList;
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
        final NotaFiscal other = (NotaFiscal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
