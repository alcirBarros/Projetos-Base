package com.estoque.movimentacao;

import com.cadastro.Laboratorio;
import com.cadastro.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pmv_produto_movimentacao")
public class ProdutoMovimentacao implements Serializable {

    private static final long serialVersionUID = 2037729290923156467L;

    @Id
    @GeneratedValue
    @Column(name = "pmv_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mvp_id", referencedColumnName = "mvp_id", nullable = false)
    private MovimentacaoProduto movimentacaoProduto;

    @ManyToOne
    @JoinColumn(name = "pdt_id", referencedColumnName = "pdt_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "lab_id", referencedColumnName = "lab_id")
    private Laboratorio laboratorio;

    @Column(name = "pmv_quantidade", nullable = false)
    private BigInteger quantidade;

    @Column(name = "pmv_valor_unitario", nullable = false)
    private BigDecimal valorUitario;

    @Column(name = "pmv_valor_total", nullable = false)
    private BigDecimal valorTotal;

    public ProdutoMovimentacao() {
    }

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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUitario() {
        return valorUitario;
    }

    public void setValorUitario(BigDecimal valorUitario) {
        this.valorUitario = valorUitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}
