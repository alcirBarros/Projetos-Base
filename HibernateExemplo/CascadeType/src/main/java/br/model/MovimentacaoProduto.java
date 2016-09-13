package br.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "mpd_movimentacao_produto", catalog = "hibernateDB")
public class MovimentacaoProduto implements Serializable {

    private static final long serialVersionUID = 8839026304036733921L;

    @Id
    @GeneratedValue
    @Column(name = "mpd_id", nullable = false)
    private Integer id;

    @Column(name = "mpd_data_hora", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora = new Date();

    @OneToMany(mappedBy = "movimentacaoProduto", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ProdutoMovimentacao> produtoMovimentacaoList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
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
        hash = 67 * hash + Objects.hashCode(this.id);
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
