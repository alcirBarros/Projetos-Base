package com.service;

import com.estoque.movimentacao.MovimentacaoProduto;
import com.estoque.movimentacao.ProdutoMovimentacao;
import com.util.Service;
import com.util.Source;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class MovimentacaoProdutoService extends Service {

    private static final long serialVersionUID = 5490373206320213157L;

    public MovimentacaoProdutoService setEm(EntityManager em) {
        super.em = em;
        return this;
    }

    public MovimentacaoProduto carregaMovimentacaoProduto(Integer movimentacaoProdutoId) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    mvp.* ");
            query.append("FROM ");
            query.append("    mvp_movimentacao_produto mvp ");
            query.append("WHERE ");
            query.append("    mvp.mvp_id = ").append(movimentacaoProdutoId);
            MovimentacaoProduto movimentacaoProduto = (MovimentacaoProduto) em.createNativeQuery(query.toString(), MovimentacaoProduto.class).getSingleResult();
            return movimentacaoProduto;
        } catch (Exception e) {
            throw e;
        }
    }

    public MovimentacaoProduto carregaMovimentacaoProdutoNumeroNota(String numeroNota) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    mvp.* ");
            query.append("FROM ");
            query.append("    mvp_movimentacao_produto mvp ");
            query.append("WHERE ");
            query.append("    mvp.mvp_numero_nota = '").append(numeroNota).append(".0'");
            MovimentacaoProduto movimentacaoProduto = (MovimentacaoProduto) em.createNativeQuery(query.toString(), MovimentacaoProduto.class).getSingleResult();
            return movimentacaoProduto;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ProdutoMovimentacao> ListaProdutoMovimentacao() {
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    pmv.* ");
            query.append("FROM ");
            query.append("    pmv_produto_movimentacao pmv ");
            query.append("       inner join ");
            query.append("    mvp_movimentacao_produto mvp on mvp.mvp_id = pmv.mvp_id ");
            query.append("where ");
            query.append("    mvp.mvp_data_cadastro between '2015-01-19 00:00:00' and '2015-01-19 23:59:59'");
            List<ProdutoMovimentacao> produtoMovimentacaoList = em.createNativeQuery(query.toString(), ProdutoMovimentacao.class).getResultList();
            return produtoMovimentacaoList;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Source> ListaProdutoMovimentacaoPorVendedor() {
        try {
            List<Source> sourceList = new ArrayList<>();
            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    vnd.vnd_nome,");
            query.append("    lab.lab_descricao, ");
            query.append("    clt.clt_nome, ");
            query.append("    SUM(pmv.pmv_quantidade), ");
            query.append("    SUM(pmv.pmv_valor_total) ");
            query.append("FROM ");
            query.append("    pmv_produto_movimentacao pmv ");
            query.append("        INNER JOIN ");
            query.append("    mvp_movimentacao_produto mvp ON mvp.mvp_id = pmv.mvp_id ");
            query.append("        INNER JOIN ");
            query.append("    lab_laboratorio lab ON pmv.lab_id = lab.lab_id ");
            query.append("        INNER JOIN ");
            query.append("    pdt_produto pdt ON pmv.pdt_id = pdt.pdt_id ");
            query.append("        INNER JOIN ");
            query.append("    vnd_vendedor vnd ON mvp.vnd_id = vnd.vnd_id ");
            query.append("        INNER JOIN ");
            query.append("    clt_cliente clt ON mvp.clt_id = clt.clt_id ");
            query.append("WHERE ");
            query.append("    mvp.mvp_data_cadastro BETWEEN '2015-07-20 00:00:00' AND '2015-07-25 23:59:59' ");
            query.append("GROUP BY vnd.vnd_id , lab.lab_id , clt.clt_id ");
            List resultList = em.createNativeQuery(query.toString()).getResultList();

            for (Object result : resultList) {
                Object[] object = (Object[]) result;

                String vnd_nome = (String) object[0];
                String lab_descricao = (String) object[1];
                String clt_nome = (String) object[2];
                BigInteger pmv_quantidade = ((BigDecimal) object[3]).toBigInteger();
                BigDecimal pmv_valor_total = (BigDecimal) object[4];

                Source source = new Source();
                source.put("vnd_nome", vnd_nome);
                source.put("lab_descricao", lab_descricao);
                source.put("clt_nome", clt_nome);
                source.put("pmv_quantidade", pmv_quantidade);
                source.put("pmv_valor_total", pmv_valor_total);

                sourceList.add(source);
            }
            return sourceList;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Source> ListaProdutoMovimentacaoVendaRealizada() {
        try {
            List<Source> sourceList = new ArrayList<>();
            StringBuilder query = new StringBuilder();

            query.append("SELECT ");
            query.append("    vnd.vnd_nome, ");
            query.append("    lab.lab_descricao, ");
            query.append("    SUM(pmv.pmv_quantidade), ");
            query.append("    SUM(pmv.pmv_valor_total) ");
            query.append("FROM ");
            query.append("    pmv_produto_movimentacao pmv ");
            query.append("        INNER JOIN ");
            query.append("    mvp_movimentacao_produto mvp ON mvp.mvp_id = pmv.mvp_id ");
            query.append("        INNER JOIN ");
            query.append("    lab_laboratorio lab ON pmv.lab_id = lab.lab_id ");
            query.append("        INNER JOIN ");
            query.append("    pdt_produto pdt ON pmv.pdt_id = pdt.pdt_id ");
            query.append("        INNER JOIN ");
            query.append("    vnd_vendedor vnd ON mvp.vnd_id = vnd.vnd_id ");
            query.append("        INNER JOIN ");
            query.append("    clt_cliente clt ON mvp.clt_id = clt.clt_id ");
            query.append("WHERE ");
            query.append("    mvp.mvp_data_cadastro BETWEEN '2015-07-20 00:00:00' AND '2015-07-25 23:59:59' ");
            query.append("GROUP BY vnd.vnd_id, lab.lab_id ");
            List resultList = em.createNativeQuery(query.toString()).getResultList();

            for (Object result : resultList) {
                Object[] object = (Object[]) result;

                String vnd_nome = (String) object[0];
                String lab_descricao = (String) object[1];
                BigInteger pmv_quantidade = ((BigDecimal) object[2]).toBigInteger();
                BigDecimal pmv_valor_total = (BigDecimal) object[3];

                Source source = new Source();
                source.put("vnd_nome", vnd_nome);
                source.put("lab_descricao", lab_descricao);
                source.put("pmv_quantidade", pmv_quantidade);
                source.put("pmv_valor_total", pmv_valor_total);

                sourceList.add(source);
            }
            return sourceList;
        } catch (Exception e) {
            throw e;
        }
    }
}
