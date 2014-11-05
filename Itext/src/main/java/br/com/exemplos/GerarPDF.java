package br.com.exemplos;

import br.com.itext.ITextUtil;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GerarPDF {

    public static void main(String args[]) {

        SolicitacaoProdutoRelatorio solicitacaoProdutoRelatorio = new SolicitacaoProdutoRelatorio("aaa", "aaa", "bbb");
        solicitacaoProdutoRelatorio.produtoSolicitadoList.add(new ProdutoSolicitadoRelatorio("aaaa", "aaa", "aaa", "aaa", "aaa"));

        geraRelatorio(solicitacaoProdutoRelatorio);
    }

    private static void geraRelatorio(SolicitacaoProdutoRelatorio solicitacaoProduto) {
        try {
            Document documento = new Document(PageSize.A4, 25, 25, 105, 40);
            OutputStream os = new FileOutputStream("out.pdf");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(documento, baos);
            documento.open();

            documento.add(ITextUtil.montarTabelaComBordaAlinhamentoCentralFundoCinza(1, new int[]{1}, solicitacaoProduto.NOME_RELATORIO));

            documento.add(ITextUtil.montarTabelaColuna(new int[]{12, 2}, "UNIDADE DE SAÚDE:" + " " + solicitacaoProduto.unidadeSaude, "MÊS:" + " " + "JANEIRO/14"));
            documento.add(ITextUtil.montarTabelaColuna(new int[]{12, 2}, "PEDIDO ELABORADO POR:" + " " + solicitacaoProduto.pedidoElaboradoPor, "DATA:" + " " + solicitacaoProduto.data));

            documento.add(ITextUtil.dataTable(new int[]{2, 11, 2, 4, 3}, "CÓDIGO", "PRODUTO", "UNID.", "SALDO ATUAL", "SOLICITADO"));
            for (ProdutoSolicitadoRelatorio produtoSolicitado : solicitacaoProduto.produtoSolicitadoList) {
                documento.add(ITextUtil.row(PdfPCell.BOX, new int[]{2, 11, 2, 4, 3}, produtoSolicitado.codigo, produtoSolicitado.descricaoProduto, produtoSolicitado.unidadeMedida, produtoSolicitado.saldoAtual, produtoSolicitado.solicitado));
            }

            documento.close();

            PdfReader reader = new PdfReader(baos.toByteArray());
            PdfStamper stamper = new PdfStamper(reader, os);
            ITextUtil.cabecalho(reader.getNumberOfPages(), stamper, "DEPARTAMENTO DE SAUDE DE SÃO JOÃO DA BOA VISTA", "solicitação de produto");
            ITextUtil.rodape(reader.getNumberOfPages(), stamper, "alci de oliveira barros", "PRONTO SOCORRO MUNICIPAL DR OSCAR P.MARTINS FILHO-SJBV");
            stamper.close();
            reader.close();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SolicitacaoProdutoRelatorio {

    public final static String NOME_RELATORIO = "INFORMAÇÕES DA SOLICITAÇÃO";

    public String unidadeSaude;
    public String pedidoElaboradoPor;
    public String data;

    public List<ProdutoSolicitadoRelatorio> produtoSolicitadoList;

    public SolicitacaoProdutoRelatorio(String unidadeSaude, String pedidoElaboradoPor, String data) {
        this.unidadeSaude = unidadeSaude;
        this.pedidoElaboradoPor = pedidoElaboradoPor;
        this.data = data;
        this.produtoSolicitadoList = produtoSolicitadoList = new ArrayList<ProdutoSolicitadoRelatorio>();
    }
}

class ProdutoSolicitadoRelatorio {

    public String codigo;
    public String descricaoProduto;
    public String unidadeMedida;
    public String saldoAtual;
    public String solicitado;

    public ProdutoSolicitadoRelatorio(String codigo, String descricaoProduto, String unidadeMedida, String saldoAtual, String solicitado) {
        this.codigo = codigo;
        this.descricaoProduto = descricaoProduto;
        this.unidadeMedida = unidadeMedida;
        this.saldoAtual = saldoAtual;
        this.solicitado = solicitado;
    }
}
