package com.relatorio;

import com.estoque.movimentacao.MovimentacaoProduto;
import com.estoque.movimentacao.ProdutoMovimentacao;
import com.util.Source;
import com.relatorio.org.interfaces.IRelatorioDynamicReports;
import com.relatorio.org.objectFake.OperadorLogado;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import javax.persistence.EntityManager;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import static net.sf.dynamicreports.report.builder.DynamicReports.asc;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import static com.relatorio.org.style.DynamicReportStyles.*;
import com.service.MovimentacaoProdutoService;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;

public class MovimentacaoProdutoPdfDynamic implements IRelatorioDynamicReports {

    private MovimentacaoProdutoService movimentacaoProdutoService;

    @Override
    public MovimentacaoProdutoPdfDynamic setEm(EntityManager em) {
        movimentacaoProdutoService = new MovimentacaoProdutoService().setEm(em);
        return this;
    }

    @Override
    public JasperReportBuilder geraRelatorioCom(Object... obj) {
        JasperReportBuilder report = report();

        VerticalListBuilder verticalList = cmp.verticalList(
                cmp.horizontalList(
                        cmp.text("Nº Movimento: ").setStyle(fonte10).setHorizontalAlignment(HorizontalAlignment.LEFT).setWidth(100)
                ),
                cmp.verticalGap(15),
                cmp.verticalList(
                        cmp.text("Cliente: ").setStyle(fonte10).setHorizontalAlignment(HorizontalAlignment.LEFT).setWidth(100),
                        cmp.text("Vendedor: ").setStyle(fonte10).setHorizontalAlignment(HorizontalAlignment.LEFT).setWidth(100)
                ),
                cmp.verticalGap(15)
        );

        report.pageHeader(verticalList);

        TextColumnBuilder<String> columnCodigo = col.column("Código", "codigo", type.stringType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);
        TextColumnBuilder<String> columnProduto = col.column("Produto", "produto", type.stringType()).setWidth(40).setHorizontalAlignment(HorizontalAlignment.LEFT).setStyle(columnPedding);
        TextColumnBuilder<String> columnlaboratorio = col.column("Labotatorio", "laboratorio", type.stringType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.LEFT).setStyle(columnPedding);
        TextColumnBuilder<BigDecimal> columnValorUnit = col.column("Valor Unit.", "valorUnitario", type.bigDecimalType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);
        TextColumnBuilder<Integer> columnQuantidade = col.column("Quant.", "quantidade", type.integerType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);
        TextColumnBuilder<BigDecimal> columnValorTotal = col.column("Valor Total", "valorTotal", type.bigDecimalType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);

        return report
                .subtotalsAtSummary(DynamicReports.sbt.sum(columnQuantidade), DynamicReports.sbt.sum(columnValorTotal))
                .columns(columnCodigo, columnProduto, columnlaboratorio, columnValorUnit, columnQuantidade, columnValorTotal)
                .sortBy(asc(columnProduto))
                .setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
    }

    @Override
    public JRDataSource createDataSource(Object obj) {
        Source source = (Source) obj;
        String movimentacaoProdutoId = (String) source.next("movimentacaoProdutoId");

        DRDataSource dataSource = new DRDataSource("codigo", "produto", "laboratorio", "valorUnitario", "quantidade", "valorTotal");
        MovimentacaoProduto movimentacaoProduto = movimentacaoProdutoService.carregaMovimentacaoProdutoNumeroNota(movimentacaoProdutoId);

        for (ProdutoMovimentacao produtoMovimentacao : movimentacaoProduto.getProdutoMovimentacaoList()) {
            dataSource.add(produtoMovimentacao.getProduto().getCodigo(), produtoMovimentacao.getProduto().getDescricao(), produtoMovimentacao.getLaboratorio().getDescricao(), produtoMovimentacao.getValorUitario(), produtoMovimentacao.getQuantidade().intValue(), produtoMovimentacao.getValorTotal());
        }

        return dataSource;
    }

    @Override
    public JasperReportBuilder parametro(Map<String, String[]> parametro, OperadorLogado operadorLogado) {
        String movimentacaoProdutoId = (parametro.get("movimentacaoProdutoId") != null) ? parametro.get("movimentacaoProdutoId")[0] : null;
        Source source = new Source();
        source.put("operadorLogado", operadorLogado);
        source.put("movimentacaoProdutoId", movimentacaoProdutoId);
        JRDataSource createDataSource = createDataSource(source);
        JasperReportBuilder reportBuilder = geraRelatorioCom(source);
        reportBuilder.setDataSource(createDataSource);
        return reportBuilder;
    }

    @Override
    public Object gerarPDF(Map<String, String[]> parametros, OperadorLogado operadorLogado, String pathRelatorios) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
