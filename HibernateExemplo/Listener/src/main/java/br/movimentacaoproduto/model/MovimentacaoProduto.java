package br.movimentacaoproduto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mpd_movimentacao_produto", schema = "hibernateDB")
public class MovimentacaoProduto implements Serializable{

    private static final long serialVersionUID = 6587925334462105282L;

    @Id
    @GeneratedValue
    @Column(name = "mpd_id", nullable = false)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "mpd_tipo_movimento", nullable = false)
    private TipoMovimento tipoMovimento;
    
    @Column(name = "mpd_processado", nullable = false)
    private Boolean processado = Boolean.FALSE;

    @OneToMany(mappedBy = "movimentacaoProduto", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ProdutoMovimentacao> produtoMovimentacaoList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Boolean getProcessado() {
        return processado;
    }

    public void setProcessado(Boolean processado) {
        this.processado = processado;
    }
        
    public List<ProdutoMovimentacao> getProdutoMovimentacaoList() {
        return produtoMovimentacaoList;
    }

    public void setProdutoMovimentacaoList(List<ProdutoMovimentacao> produtoMovimentacaoList) {
        this.produtoMovimentacaoList = produtoMovimentacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final MovimentacaoProduto other = (MovimentacaoProduto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}