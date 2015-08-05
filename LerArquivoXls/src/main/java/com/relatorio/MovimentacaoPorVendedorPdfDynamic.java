package com.relatorio;

import com.estoque.movimentacao.ProdutoMovimentacao;
import com.relatorio.org.interfaces.IRelatorioDynamicReports;
import com.relatorio.org.objectFake.OperadorLogado;
import static com.relatorio.org.style.DynamicReportStyles.*;
import com.service.MovimentacaoProdutoService;
import com.util.Source;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import static net.sf.dynamicreports.report.builder.DynamicReports.asc;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;

public class MovimentacaoPorVendedorPdfDynamic implements IRelatorioDynamicReports {

    private MovimentacaoProdutoService movimentacaoProdutoService;

    @Override
    public Object setEm(EntityManager em) {
        movimentacaoProdutoService = new MovimentacaoProdutoService().setEm(em);
        return this;
    }

    @Override
    public JasperReportBuilder geraRelatorioCom(Object... obj) {
        JasperReportBuilder report = report();

        TextColumnBuilder<String> columnVendedor = col.column("Vendedor", "vendedor", type.stringType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.LEFT).setStyle(columnPedding);
        TextColumnBuilder<String> columnlaboratorio = col.column("Labotatorio", "laboratorio", type.stringType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.LEFT).setStyle(columnPedding);
        TextColumnBuilder<String> columnCliente = col.column("Cliente", "cliente", type.stringType()).setWidth(30).setHorizontalAlignment(HorizontalAlignment.LEFT).setStyle(columnPedding);
        TextColumnBuilder<Integer> columnQuantidade = col.column("Quant.", "quantidade", type.integerType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);
        TextColumnBuilder<BigDecimal> columnValorTotal = col.column("Valor Total", "valorTotal", type.bigDecimalType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);

  
        
        
        ColumnGroupBuilder itemGroup = grp.group(columnVendedor)
                .setTitleWidth(30)
                .reprintHeaderOnEachPage()
                // .startInNewPage()
                .setHeaderLayout(GroupHeaderLayout.VALUE).setStyle(styleProduto)
                .setMinHeightToStartNewPage(13)
                .setPadding(0);

        return report
                .subtotalsAtSummary(sbt.sum(columnQuantidade), sbt.sum(columnValorTotal))
                .subtotalsAtGroupFooter(itemGroup, sbt.sum(columnQuantidade), sbt.sum(columnValorTotal))
                .columns(columnVendedor, columnlaboratorio, columnCliente, columnQuantidade, columnValorTotal)
                .columnGrid(columnlaboratorio, columnCliente, columnQuantidade, columnValorTotal)
                .sortBy(asc(columnVendedor), asc(columnlaboratorio), asc(columnCliente))
                .setShowColumnTitle(false)
                .groupBy(itemGroup)
                .setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
    }

    @Override
    public JRDataSource createDataSource(Object obj) {
        Source source = (Source) obj;
        //Integer movimentacaoProdutoId = Integer.valueOf((String) source.next("movimentacaoProdutoId"));

        DRDataSource dataSource = new DRDataSource("vendedor", "laboratorio", "cliente", "quantidade", "valorTotal");
        List<Source> ListaProdutoMovimentacaoPorVendedor = movimentacaoProdutoService.ListaProdutoMovimentacaoPorVendedor();

        for (Source sourceMovimentacao : ListaProdutoMovimentacaoPorVendedor) {

            String vnd_nome = (String) sourceMovimentacao.next("vnd_nome");
            String lab_descricao = (String) sourceMovimentacao.next("lab_descricao");
            String clt_nome = (String) sourceMovimentacao.next("clt_nome");
            BigInteger pmv_quantidade = (BigInteger) sourceMovimentacao.next("pmv_quantidade");
            BigDecimal pmv_valor_total = (BigDecimal) sourceMovimentacao.next("pmv_valor_total");

            dataSource.add(vnd_nome, lab_descricao, clt_nome, pmv_quantidade.intValue(), pmv_valor_total);
        }

        return dataSource;
    }

    @Override
    public JasperReportBuilder parametro(Map<String, String[]> parametro, OperadorLogado operadorLogado) {
        //String movimentacaoProdutoId = (parametro.get("movimentacaoProdutoId") != null) ? parametro.get("movimentacaoProdutoId")[0] : null;
        Source source = new Source();
        source.put("operadorLogado", operadorLogado);
        //source.put("movimentacaoProdutoId", movimentacaoProdutoId);
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
