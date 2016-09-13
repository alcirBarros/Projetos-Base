package br.movimentacaoproduto.listener;

import br.movimentacaoproduto.model.MovimentacaoProduto;
import br.movimentacaoproduto.model.ProdutoMovimentacao;
import br.movimentacaoproduto.model.SaldoEstoque;
import br.movimentacaoproduto.model.TipoMovimento;
import java.math.BigDecimal;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ProdutoMovimentacaoListener {

    @PrePersist
    public void prePersist(ProdutoMovimentacao produtoMovimentacao) {

        MovimentacaoProduto movimentacaoProduto = produtoMovimentacao.getMovimentacaoProduto();
        TipoMovimento tipoMovimento = produtoMovimentacao.getMovimentacaoProduto().getTipoMovimento();
        SaldoEstoque saldoEstoque = produtoMovimentacao.getSaldoEstoque();

        if (tipoMovimento.equals(TipoMovimento.SAIDA)) {

            BigDecimal quantidade = produtoMovimentacao.getQuantidade();
            produtoMovimentacao.setQuantidadeAnterior(quantidade);

            BigDecimal saldoReserva = saldoEstoque.getSaldoReserva().add(quantidade);
            saldoEstoque.setSaldoReserva(saldoReserva);
        }
        System.out.println("Listening Pesssoa Pre Persist : ");
    }

    @PreUpdate
    public void preUpdate(ProdutoMovimentacao produtoMovimentacao) {

        MovimentacaoProduto movimentacaoProduto = produtoMovimentacao.getMovimentacaoProduto();
        TipoMovimento tipoMovimento = movimentacaoProduto.getTipoMovimento();
        SaldoEstoque saldoEstoque = produtoMovimentacao.getSaldoEstoque();

        if (tipoMovimento.equals(TipoMovimento.SAIDA)) {
            BigDecimal quantidadeAnterior = produtoMovimentacao.getQuantidadeAnterior();
            BigDecimal saldoReserva = saldoEstoque.getSaldoReserva().subtract(quantidadeAnterior);
            saldoEstoque.setSaldoReserva(saldoReserva);

            BigDecimal quantidade = produtoMovimentacao.getQuantidade();
            BigDecimal novoSaldoReserva = saldoEstoque.getSaldoReserva().add(quantidade);

            saldoEstoque.setSaldoReserva(novoSaldoReserva);
        }
        System.out.println("Listening Pesssoa Pre Update : ");
    }

    @PreRemove
    public void userPreRemove(ProdutoMovimentacao produtoMovimentacao) {

        MovimentacaoProduto movimentacaoProduto = produtoMovimentacao.getMovimentacaoProduto();
        TipoMovimento tipoMovimento = movimentacaoProduto.getTipoMovimento();
        SaldoEstoque saldoEstoque = produtoMovimentacao.getSaldoEstoque();

        if (tipoMovimento.equals(TipoMovimento.SAIDA)) {
            BigDecimal quantidade = produtoMovimentacao.getQuantidade();
            BigDecimal saldoReserva = saldoEstoque.getSaldoReserva().subtract(quantidade);
            saldoEstoque.setSaldoReserva(saldoReserva);
        }

        System.out.println("Listening Pesssoa Pre Remove : ");
    }
}
