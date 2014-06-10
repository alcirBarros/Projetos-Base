package br.com.itext;

import static br.com.itext.ITextUtil_.FONTE_NEGRITO_8;
import static br.com.itext.ITextUtil_.FONTE_NORMAL_7_BRANCO;
import static br.com.itext.ITextUtil_.FONTE_NORMAL_9;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.IOException;
import java.net.MalformedURLException;

public class ITextUtil {

    public static final Font FONTE_NEGRITO_9 = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
    public static final Font FONTE_NEGRITO_10 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    public static final Font FONTE_NEGRITO_12 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    public static final Font FONTE_NEGRITO_14 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
    public static final Font FONTE_NEGRITO_17 = new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD);

    public static PdfPTable montarTabelaComBordaAlinhamentoCentralFundoCinza(int colunas, int[] espacamento, String texto) throws DocumentException {
        PdfPTable tabela = montarTabela(colunas, espacamento);

        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBackgroundColor(BaseColor.DARK_GRAY);
        celula.setPhrase(new Phrase(texto, FONTE_NORMAL_7_BRANCO));
        celula.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBorderColor(BaseColor.DARK_GRAY);
        tabela.addCell(celula);
        tabela.setSpacingBefore(5);
        return tabela;
    }

    public static PdfPTable montarTabela(int colunas, int[] espacamento) throws DocumentException {
        PdfPTable tabela = new PdfPTable(colunas);
        tabela.setWidths(espacamento);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(1);

        return tabela;
    }

    public static PdfPTable montarTabelaColuna(int[] espacamento, String... conteudo) throws DocumentException {
        if (espacamento.length == conteudo.length) {
            PdfPTable tabela = montarTabela(espacamento.length, espacamento);
            PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

            for (String i : conteudo) {
                celula.setPhrase(new Phrase(i, FONTE_NEGRITO_8));
                tabela.addCell(celula);

            }
            return tabela;
        }
        System.out.println("iText: valores diferentes entre colunas e conteudos");
        return new PdfPTable(espacamento.length);
    }

    public static PdfPCell montarCelulaSemBordaAlinhamentoEsquerda() {
        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celula.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celula.setBorder(PdfPCell.NO_BORDER);

        return celula;
    }

    public static PdfPTable dataTable(int[] espacamento, String... conteudo) throws DocumentException {
        if (espacamento.length == conteudo.length) {
            PdfPTable tabela = montarTabela(espacamento.length, espacamento);
            tabela.setSpacingAfter(-1);
            PdfPCell celula = montarCelula();
            celula.setBackgroundColor(BaseColor.LIGHT_GRAY);

            for (String i : conteudo) {
                celula.setPhrase(new Phrase(i, FONTE_NORMAL_9));
                tabela.addCell(celula);

            }
            return tabela;
        }
        System.out.println("iText: valores diferentes entre colunas e conteudos");
        return new PdfPTable(espacamento.length);
    }

    public static PdfPCell montarCelula() {
        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celula.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        return celula;
    }

    public static PdfPTable row(int b, int[] espacamento, String... conteudo) throws DocumentException {
        if (espacamento.length == conteudo.length) {
            PdfPTable tabela = montarTabela(espacamento.length, espacamento);
            tabela.setSpacingAfter(-1);
            PdfPCell celula = celula(b);

            for (String i : conteudo) {
                celula.setPhrase(new Phrase(i, FONTE_NORMAL_9));
                tabela.addCell(celula);

            }
            return tabela;
        }
        System.out.println("iText: valores diferentes entre colunas e conteudos");
        return new PdfPTable(espacamento.length);
    }

    public static PdfPCell celula(int b) {
        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celula.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celula.setBorder(b);

        return celula;
    }

    public static void cabecalho(int numeroDePaginas, PdfStamper stamper, String nomeOrgaoDeSaude, String nomeRelatorio) throws Exception {

        for (int i = 1; i <= numeroDePaginas; i++) {

            montarCabecalho(nomeRelatorio, nomeOrgaoDeSaude).writeSelectedRows(0, -1, 23, 825, stamper.getOverContent(i));

//            if (foto != null) {
//                montarFoto(foto).writeSelectedRows(0, -1, 34, 830, stamper.getOverContent(i));
//            }
        }
    }

    public static PdfPTable montarRodape(int x, int y, String operadorLogado, String nomeUnidadeSaude) throws DocumentException {
        PdfPTable table = montarTabela(5, new int[]{3, 12, 3, 16, 3});
        table.setTotalWidth(527);
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(700);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.addCell(montarCelulaColuna("Operador: "));
        table.addCell(montarCelulaConteudo(operadorLogado.toUpperCase()));
        table.addCell(montarCelulaColuna("Unidade: "));
        table.addCell(montarCelulaConteudo(nomeUnidadeSaude.toUpperCase()));
        table.addCell(montarCelula(x + " de " + y, FONTE_NEGRITO_9));
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        return table;
    }

    public static PdfPCell montarCelulaColuna(String conteudo) {
        PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

        celula.setPhrase(new Phrase(conteudo, FONTE_NEGRITO_8));

        return celula;
    }

    public static PdfPCell montarCelulaConteudo(String conteudo) {
        PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

        celula.setPhrase(new Phrase(conteudo, FONTE_NORMAL_9));

        return celula;
    }

    public static PdfPCell montarCelula(String conteudo, Font fonte) {
        PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

        celula.setPhrase(new Phrase(conteudo, fonte));

        return celula;
    }

    public static PdfPTable montarCabecalho(String nomeRelatorio, String NomeMunicipio) throws DocumentException {

        PdfPTable cabecalho = new PdfPTable(1);
        cabecalho.setWidths(new int[]{1});
        cabecalho.setWidthPercentage(100);
        cabecalho.setSpacingBefore(1);
        cabecalho.setTotalWidth(550);
        cabecalho.setSpacingAfter(0);
        cabecalho.setWidthPercentage(100);
        
        
        
        
        PdfPTable cabecalho2 = new PdfPTable(new float[]{1f, 5f});
        cabecalho2.setTotalWidth(527);
        cabecalho2.setSpacingAfter(0);
        cabecalho2.setWidthPercentage(100);
        
        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setRowspan(6);

        cell.setPhrase(new Phrase("", FONTE_NEGRITO_17));
        cabecalho2.addCell(cell);

        cell.setRowspan(1);
        if (NomeMunicipio.length() > 30) {
            cell.setPhrase(new Phrase(NomeMunicipio, FONTE_NEGRITO_14));
        } else {
            cell.setPhrase(new Phrase(NomeMunicipio, FONTE_NEGRITO_17));
        }
        cabecalho2.addCell(cell);

        cell.setPhrase(new Phrase("aaaaaaaaaaaaaaaaaaa (111111111111111111)", FONTE_NORMAL_9));
        cabecalho2.addCell(cell);

        cell.setPhrase(new Phrase("aaaaaaaaaaaaaaaa", FONTE_NORMAL_9));
        cabecalho2.addCell(cell);

        if (nomeRelatorio.length() < 40) {
            cell.setPhrase(new Phrase(nomeRelatorio.toUpperCase(), FONTE_NEGRITO_14));
            cabecalho2.addCell(cell);
        } else if (nomeRelatorio.length() < 80 && nomeRelatorio.length() >= 40) {
            cell.setPhrase(new Phrase(nomeRelatorio.toUpperCase(), FONTE_NEGRITO_12));
            cabecalho2.addCell(cell);
        } else {
            cell.setPhrase(new Phrase(nomeRelatorio.toUpperCase(), FONTE_NEGRITO_10));
            cabecalho2.addCell(cell);
        }
        cabecalho2.completeRow();
        
        
        
//        
//        PdfPTable cabecalho2 = new PdfPTable(new float[]{1f, 5f});
//        cabecalho2.setTotalWidth(527);
//        cabecalho2.setSpacingAfter(0);
//        cabecalho2.setWidthPercentage(100);
//        
//        
//        PdfPCell cell3 = new PdfPCell();
//        cell3.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
//        cell3.setBorder(PdfPCell.NO_BORDER);
//        cell3.setPhrase(new Phrase("aaaaaaaaaaa", FONTE_NEGRITO_17));
//        cabecalho2.addCell(cell3);
//        
//        
//        PdfPCell cell4 = new PdfPCell();
//        cell4.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
//        cell4.setBorder(PdfPCell.NO_BORDER);
//        cell4.setPhrase(new Phrase("aaaaaaaaaaa", FONTE_NEGRITO_17));
//        cabecalho2.addCell(cell4);
        
        
        
        
      //  PdfPCell cell1 = new PdfPCell();
        cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.addElement(cabecalho2);
        
        
        cabecalho.addCell(cell);
        
        
        
        
        
        
        
        

        cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setPhrase(new Phrase("_____________________________________________________________________________________________________________", FONTE_NORMAL_9));
        cabecalho.addCell(cell);
        return cabecalho;

    }

    public static PdfPTable montarFoto(byte[] foto) {
        try {
            Image imagem = Image.getInstance(foto);
            PdfPTable tabelaFoto = new PdfPTable(1);
            tabelaFoto.setTotalWidth(55);
            tabelaFoto.setSpacingAfter(0);
            tabelaFoto.setWidthPercentage(55);
            PdfPCell cell = new PdfPCell();

            cell.setHorizontalAlignment(Paragraph.ALIGN_LEFT);
            cell.setBorder(PdfPCell.NO_BORDER);

            cell.setImage(imagem);
            tabelaFoto.addCell(cell);

            return tabelaFoto;
        } catch (BadElementException bex) {
            bex.printStackTrace();
            return new PdfPTable(1);
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
            return new PdfPTable(1);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return new PdfPTable(1);
        }
    }

    public static void rodape(int numeroDePaginas, PdfStamper stamper, String nomeOperadorLogado, String nomeOrgaoSaude) throws Exception {
        for (int i = 1; i <= numeroDePaginas; i++) {
            montarRodape(i, numeroDePaginas, nomeOperadorLogado, nomeOrgaoSaude).writeSelectedRows(0, -1, 25, 25, stamper.getOverContent(i));
//            if (foto != null) {
//                montarFoto(foto).writeSelectedRows(0, -1, 34, 830, stamper.getOverContent(i));
//            }
        }

    }
}
