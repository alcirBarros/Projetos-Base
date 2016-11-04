package br.movimentacaoproduto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ses_saldo_estoque", schema = "hibernateDB")
public class SaldoEstoque implements Serializable {

    private static final long serialVersionUID = 3763683487901370452L;

    @Id
    @GeneratedValue
    @Column(name = "ses_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pdt_id", referencedColumnName = "pdt_id", foreignKey = @ForeignKey(name = "fk_ses_pdt_id"))
    private Produto produto;

    @Column(name = "ses_quantidade", precision = 11, scale = 0, nullable = false)
    private BigDecimal quantidade = BigDecimal.ZERO;

    @Column(name = "ses_reserva", precision = 11, scale = 0, nullable = false)
    private BigDecimal saldoReserva = BigDecimal.ZERO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getSaldoReserva() {
        return saldoReserva;
    }

    public void setSaldoReserva(BigDecimal saldoReserva) {
        this.saldoReserva = saldoReserva;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final SaldoEstoque other = (SaldoEstoque) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}