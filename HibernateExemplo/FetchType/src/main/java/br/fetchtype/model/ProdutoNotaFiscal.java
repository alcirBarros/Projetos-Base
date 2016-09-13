package br.fetchtype.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pnf_produto_nota_fiscal", catalog = "hibernateDB")
public class ProdutoNotaFiscal implements Serializable {

    private static final long serialVersionUID = 5668302551280630340L;

    @Id
    @GeneratedValue
    @Column(name = "pnf_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ntf_id", referencedColumnName = "ntf_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pnf_ntf_id"))
    private NotaFiscal notaFiscal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pdt_id", referencedColumnName = "pdt_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pnf_pdt_id"))
    private Produto produto;

    public ProdutoNotaFiscal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ProdutoNotaFiscal other = (ProdutoNotaFiscal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
