package br.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pmv_produto_movimentacao", catalog = "hibernateDB")
public class ProdutoMovimentacao implements Serializable{

    private static final long serialVersionUID = -4702220191885535370L;

    @Id
    @GeneratedValue
    @Column(name = "pmv_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mpd_id", referencedColumnName = "mpd_id", foreignKey = @ForeignKey(name = "fk_pmv_mpd_id"), nullable = false)
    private MovimentacaoProduto movimentacaoProduto;

    @ManyToOne
    @JoinColumn(name = "ses_id", referencedColumnName = "ses_id", foreignKey = @ForeignKey(name = "fk_pmv_ses_id"))
    private SaldoEstoque saldoEstoque;
    
    @Column(name = "pmv_quantidade", precision = 19, scale = 0, nullable = false)
    private BigDecimal quantidade;

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

    public SaldoEstoque getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(SaldoEstoque saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

}
