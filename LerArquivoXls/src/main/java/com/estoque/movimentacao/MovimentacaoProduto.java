package com.estoque.movimentacao;

import com.cadastro.Cliente;
import com.cadastro.Vendedor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;

@Entity
@Table(name = "mvp_movimentacao_produto")
public class MovimentacaoProduto implements Serializable {

    private static final long serialVersionUID = 3998057737713037233L;

    @Id
    @GeneratedValue
    @Column(name = "mvp_id", nullable = false)
    private Integer id;

    @Column(name = "mvp_numero_nota", nullable = false)
    private String numeroNota;

    @Column(name = "mvp_data_cadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "vnd_id", referencedColumnName = "vnd_id")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "clt_id", referencedColumnName = "clt_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "movimentacaoProduto", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ProdutoMovimentacao> produtoMovimentacaoList = new ArrayList<>();

    public MovimentacaoProduto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoMovimentacao> getProdutoMovimentacaoList() {
        return produtoMovimentacaoList;
    }

    public void setProdutoMovimentacaoList(List<ProdutoMovimentacao> produtoMovimentacaoList) {
        this.produtoMovimentacaoList = produtoMovimentacaoList;
    }

}
