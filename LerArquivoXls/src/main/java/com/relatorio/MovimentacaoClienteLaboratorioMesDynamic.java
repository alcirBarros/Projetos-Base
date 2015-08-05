package com.relatorio;

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
import static net.sf.dynamicreports.report.builder.DynamicReports.asc;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grid;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;

public class MovimentacaoClienteLaboratorioMesDynamic implements IRelatorioDynamicReports {

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
        
        
        TextColumnBuilder<BigDecimal> column1ValorTotal = col.column("Valor Total", "valorTotal1", type.bigDecimalType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);
        TextColumnBuilder<BigDecimal> column2ValorTotal = col.column("Valor Total", "valorTotal2", type.bigDecimalType()).setWidth(10).setHorizontalAlignment(HorizontalAlignment.RIGHT).setStyle(columnNumberStyle);

        
        ColumnTitleGroupBuilder movimentoTilte = grid.titleGroup("Janeiro", column1ValorTotal, column2ValorTotal);
        
        
        ColumnGroupBuilder itemGroup = grp.group(columnVendedor)
                .setTitleWidth(30)
                .showColumnHeaderAndFooter()
                .reprintHeaderOnEachPage()
                // .startInNewPage()
                .setHeaderLayout(GroupHeaderLayout.VALUE).setStyle(styleProduto)
                .setMinHeightToStartNewPage(13)
                .setPadding(0);

        return report
                .setColumnTitleStyle(stl.style(columnTitleStyle).setFontSize(6).setVerticalAlignment(VerticalAlignment.MIDDLE))
                
                .columns(columnVendedor, columnCliente, columnlaboratorio, columnQuantidade, column1ValorTotal, column2ValorTotal)
                
                .columnGrid(columnCliente, columnlaboratorio, columnQuantidade, movimentoTilte)
                
                .sortBy(asc(columnVendedor), asc(columnCliente))
                .setShowColumnTitle(false)
                .groupBy(itemGroup)
                .setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
    }

    @Override
    public JRDataSource createDataSource(Object obj) {
        Source source = (Source) obj;

        DRDataSource dataSource = new DRDataSource("vendedor", "cliente", "laboratorio", "quantidade", "valorTotal1", "valorTotal1");

        //List<Source> ListaProdutoMovimentacaoPorVendedor = movimentacaoProdutoService.ListaProdutoMovimentacaoPorVendedor();
        dataSource.add("aa", "aa", "aa", 1, BigDecimal.ZERO);

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
