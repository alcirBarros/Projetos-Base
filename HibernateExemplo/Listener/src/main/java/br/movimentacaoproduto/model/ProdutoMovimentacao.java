package br.movimentacaoproduto.model;

import br.movimentacaoproduto.listener.ProdutoMovimentacaoListener;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@EntityListeners(ProdutoMovimentacaoListener.class)
@Table(name = "pmv_produto_movimentacao", schema = "hibernateDB")
public class ProdutoMovimentacao implements Serializable {

    private static final long serialVersionUID = 1303945368078838783L;

    @Id
    @GeneratedValue
    @Column(name = "pmv_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mpd_id", referencedColumnName = "mpd_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pmv_mpd_id"))
    private MovimentacaoProduto movimentacaoProduto;

    @ManyToOne
    @JoinColumn(name = "pdt_id", referencedColumnName = "pdt_id", foreignKey = @ForeignKey(name = "fk_pmv_pdt_id"))
    private Produto produto;

    @Column(name = "pmv_quantidade_anterior", precision = 11, scale = 0)
    private BigDecimal quantidadeAnterior = BigDecimal.ZERO;

    @Column(name = "pmv_quantidade", precision = 11, scale = 0)
    private BigDecimal quantidade = BigDecimal.ZERO;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ses_id", referencedColumnName = "ses_id", foreignKey = @ForeignKey(name = "fk_pmv_ses_id"))
    private SaldoEstoque saldoEstoque;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovimentacaoProduto getMovimentacaoProduto() {
        return movimentacaoProduto;
    }

    public void setMovimentacaoProduto(MovimentacaoProduto movimentacaoProduto) {
        this.movimentacaoProduto = movimentacaoProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidadeAnterior() {
        return quantidadeAnterior;
    }

    public void setQuantidadeAnterior(BigDecimal quantidadeAnterior) {
        this.quantidadeAnterior = quantidadeAnterior;
    }
    
    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public SaldoEstoque getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(SaldoEstoque saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ProdutoMovimentacao other = (ProdutoMovimentacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
