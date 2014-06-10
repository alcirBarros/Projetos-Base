package br.com.itext;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class ITextUtil_ implements Serializable {

    public static final Font FONTE_NORMAL_8 = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
    public static final Font FONTE_NORMAL_9 = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
    public static final Font FONTE_NORMAL_7_BRANCO = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.WHITE);
    public static final Font FONTE_NORMAL_10 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
    public static final Font FONTE_NORMAL_11 = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);
    public static final Font FONTE_NORMAL_12 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
    public static final Font FONTE_NORMAL_13 = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL);
    public static final Font FONTE_NEGRITO_8 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
    public static final Font FONTE_NEGRITO_9 = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
    public static final Font FONTE_NEGRITO_10 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    public static final Font FONTE_NEGRITO_11 = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
    public static final Font FONTE_NEGRITO_12 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    public static final Font FONTE_NEGRITO_14 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
    public static final Font FONTE_NEGRITO_15 = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD);
    public static final Font FONTE_NEGRITO_17 = new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD);
    public static final Font FONTE_NEGRITO_20 = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);

//    public PdfPTable montarCabecalho(Relatorio relatorio, Municipio municipio) {
//        PdfPTable cabecalho = new PdfPTable(new float[]{1f, 5f});
//        cabecalho.setTotalWidth(527);
//        cabecalho.setSpacingAfter(0);
//        cabecalho.setWidthPercentage(100);
//        PdfPCell cell = new PdfPCell();
//
//        cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
//        cell.setBorder(PdfPCell.NO_BORDER);
//        cell.setRowspan(6);
//
//        cell.setPhrase(new Phrase("", FONTE_NEGRITO_17));
//        cabecalho.addCell(cell);
//
//        cell.setRowspan(1);
//        if (municipio.getOrgaoDeSaude().getInstituicao().getNomeFantasia().length() > 30) {
//            cell.setPhrase(new Phrase(municipio.getOrgaoDeSaude().getInstituicao().getNomeFantasia(), FONTE_NEGRITO_14));
//        } else {
//            cell.setPhrase(new Phrase(municipio.getOrgaoDeSaude().getInstituicao().getNomeFantasia(), FONTE_NEGRITO_17));
//        }
//        cabecalho.addCell(cell);
//
//        cell.setPhrase(new Phrase(municipio.getOrgaoDeSaude().getInstituicao().getEndereco().displayForReports(), FONTE_NORMAL_9));
//        cabecalho.addCell(cell);
//
//        cell.setPhrase(new Phrase(municipio.getOrgaoDeSaude().getInstituicao().displayContatos(), FONTE_NORMAL_9));
//        cabecalho.addCell(cell);
//
//        if (relatorio.getNome().length() < 40) {
//            cell.setPhrase(new Phrase(relatorio.getNome().toUpperCase(), FONTE_NEGRITO_14));
//            cabecalho.addCell(cell);
//        } else if (relatorio.getNome().length() < 80 && relatorio.getNome().length() >= 40) {
//            cell.setPhrase(new Phrase(relatorio.getNome().toUpperCase(), FONTE_NEGRITO_12));
//            cabecalho.addCell(cell);
//        } else {
//            cell.setPhrase(new Phrase(relatorio.getNome().toUpperCase(), FONTE_NEGRITO_10));
//            cabecalho.addCell(cell);
//        }
//        cell.setPhrase(new Phrase("____________________________________________________________________________________", FONTE_NORMAL_9));
//        cabecalho.addCell(cell);
//
//        cabecalho.completeRow();
//
//        return cabecalho;
//    }
    public PdfPTable montarFoto(byte[] foto) {
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

//    public PdfPTable montarCabecalhoLandscape(Relatorio relatorio, Municipio municipio) {
//        PdfPTable cabecalho = new PdfPTable(new float[]{1f, 5f});
//        cabecalho.setTotalWidth(767);
//        cabecalho.setSpacingAfter(0);
//        cabecalho.setWidthPercentage(100);
//
//        PdfPCell cell = new PdfPCell();
//        cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
//        cell.setBorder(PdfPCell.NO_BORDER);
//        cell.setRowspan(6);
//
//        cell.setPhrase(new Phrase("", FONTE_NEGRITO_17));
//        cabecalho.addCell(cell);
//
//        cell.setRowspan(1);
//        cell.setPhrase(new Phrase(municipio.getOrgaoDeSaude().getInstituicao().getNomeFantasia(), FONTE_NEGRITO_17));
//        cabecalho.addCell(cell);
//
//        cell.setPhrase(new Phrase(municipio.getOrgaoDeSaude().getInstituicao().getEndereco().displayForReports(), FONTE_NORMAL_9));
//        cabecalho.addCell(cell);
//
//        cell.setPhrase(new Phrase(municipio.getOrgaoDeSaude().getInstituicao().displayContatos(), FONTE_NORMAL_9));
//        cabecalho.addCell(cell);
//
//        if (relatorio.getNome().length() < 40) {
//            cell.setPhrase(new Phrase(relatorio.getNome(), FONTE_NEGRITO_14));
//            cabecalho.addCell(cell);
//        } else {
//            cell.setPhrase(new Phrase(relatorio.getNome(), FONTE_NEGRITO_12));
//            cabecalho.addCell(cell);
//        }
//        cell.setPhrase(new Phrase("__________________________________________________________________________________________________________________________", FONTE_NORMAL_9));
//        cabecalho.addCell(cell);
//
//        cabecalho.completeRow();
//
//        return cabecalho;
//    }
    public PdfPTable montarHorarioOperador(String operadorLogado) throws DocumentException {
        PdfPTable tabela = montarTabela(5, new int[]{14, 4, 10, 4, 6});
        tabela.setSpacingAfter(10);
        tabela.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(Paragraph.ALIGN_RIGHT);
        cell.setBorder(PdfPCell.NO_BORDER);

        cell.setPhrase(new Phrase("", FONTE_NEGRITO_8));
        tabela.addCell(cell);

        cell.setPhrase(new Phrase("Operador: ", FONTE_NEGRITO_8));
        tabela.addCell(cell);

        cell.setPhrase(new Phrase(operadorLogado, FONTE_NORMAL_8));
        tabela.addCell(cell);

        cell.setPhrase(new Phrase("Data/Hora: ", FONTE_NEGRITO_8));
        tabela.addCell(cell);

        cell.setPhrase(new Phrase(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()), FONTE_NORMAL_8));
        tabela.addCell(cell);

        return tabela;
    }

    public Document montarDocumento() throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4, 40, 40, 120, 40);

        return documento;
    }

    public Document montarDocumentoLandscape() throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4.rotate(), 40, 40, 93, 40);

        return documento;
    }

//    public HeaderFooter montarFooter(){
//        
//    }
    public PdfPTable montarTabela(int colunas, int[] espacamento) throws DocumentException {
        PdfPTable tabela = new PdfPTable(colunas);
        tabela.setWidths(espacamento);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(1);

        return tabela;
    }

    public PdfPCell montarCelulaSemBordaAlinhamentoEsquerda() {
        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celula.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celula.setBorder(PdfPCell.NO_BORDER);

        return celula;
    }

    public PdfPCell montarCelula() {
        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celula.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        return celula;
    }

    public PdfPTable montarTabelaComBordaAlinhamentoCentral(int colunas, int[] espacamento, String texto) throws DocumentException {
        PdfPTable tabela = montarTabela(colunas, espacamento);

        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBackgroundColor(BaseColor.BLACK);
        celula.setPhrase(new Phrase(texto, FONTE_NORMAL_7_BRANCO));
        celula.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tabela.addCell(celula);
        tabela.setSpacingBefore(5);
//        celula.setBorder(PdfPCell.NO_BORDER);

        return tabela;
    }

    public PdfPTable montarTabelaComBordaAlinhamentoCentral(int[] espacamento, String texto1, String texto2) throws DocumentException {
        PdfPTable tabela = montarTabela(espacamento.length, espacamento);

        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBackgroundColor(BaseColor.BLACK);
        celula.setPhrase(new Phrase(texto1, FONTE_NORMAL_7_BRANCO));
        celula.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tabela.addCell(celula);
        celula.setPhrase(new Phrase(texto2, FONTE_NORMAL_7_BRANCO));
        tabela.addCell(celula);
        tabela.setSpacingBefore(5);
//        celula.setBorder(PdfPCell.NO_BORDER);

        return tabela;
    }

    public PdfPTable montarTabelaComBordaAlinhamentoCentralFundoCinza(int colunas, int[] espacamento, String texto) throws DocumentException {
        PdfPTable tabela = montarTabela(colunas, espacamento);

        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBackgroundColor(BaseColor.DARK_GRAY);
        celula.setPhrase(new Phrase(texto, FONTE_NORMAL_7_BRANCO));
        celula.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBorderColor(BaseColor.DARK_GRAY);
        tabela.addCell(celula);
        tabela.setSpacingBefore(5);
//        celula.setBorder(PdfPCell.NO_BORDER);

        return tabela;
    }

    public PdfPTable montarTabelaComBordaAlinhamentoCentralFundoCinza(int[] espacamento, String texto, String texto2) throws DocumentException {
        PdfPTable tabela = montarTabela(espacamento.length, espacamento);

        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBackgroundColor(BaseColor.DARK_GRAY);
        celula.setPhrase(new Phrase(texto, FONTE_NORMAL_7_BRANCO));
        celula.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celula.setBorderColor(BaseColor.DARK_GRAY);
        tabela.addCell(celula);

        celula.setPhrase(new Phrase(texto2, FONTE_NORMAL_7_BRANCO));
        tabela.addCell(celula);
        tabela.setSpacingBefore(5);
//        celula.setBorder(PdfPCell.NO_BORDER);

        return tabela;
    }

    public Phrase montarPhraseConteudo(String conteudo) {
        return new Phrase(conteudo, FONTE_NORMAL_9);
    }

    public Phrase montarPhraseColuna(String conteudo) {
        return new Phrase(conteudo, FONTE_NEGRITO_8);
    }

    public PdfPCell montarCelulaConteudo(String conteudo) {
        PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

        celula.setPhrase(new Phrase(conteudo, FONTE_NORMAL_9));

        return celula;
    }

    public PdfPTable montarTabelaColuna(int[] espacamento, String... conteudo) throws DocumentException {
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

    public PdfPTable montarTabelaConteudo(int quantidade, int[] espacamento, String... conteudo) throws DocumentException {
        if (espacamento.length == conteudo.length) {
            PdfPTable tabela = montarTabela(espacamento.length, espacamento);
            PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

            for (int x = 1; x < quantidade; x++) {
                for (String i : conteudo) {
                    celula.setPhrase(new Phrase(i, FONTE_NORMAL_9));
                    tabela.addCell(celula);

                }
            }
            return tabela;
        }
        System.out.println("iText: valores diferentes entre colunas e conteudos");
        return new PdfPTable(espacamento.length);
    }

    public PdfPTable montarTabelaConteudo(int[] espacamento, String... conteudo) throws DocumentException {
        if (espacamento.length == conteudo.length) {
            PdfPTable tabela = montarTabela(espacamento.length, espacamento);
            PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

            for (String i : conteudo) {
                celula.setPhrase(new Phrase(i, FONTE_NORMAL_9));
                tabela.addCell(celula);

            }
            return tabela;
        }
        System.out.println("iText: valores diferentes entre colunas e conteudos");
        return new PdfPTable(espacamento.length);
    }

    public PdfPTable dataTable(int[] espacamento, String... conteudo) throws DocumentException {
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

    /*
     *Create row
     */
    public PdfPTable row(int b, int[] espacamento, String... conteudo) throws DocumentException {
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

    public PdfPCell celula(int b) {
        PdfPCell celula = new PdfPCell();
        celula.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celula.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celula.setBorder(b);

        return celula;
    }

    public PdfPTable montarTabelaConteudo(int[] espacamento, BaseColor baseColor, String... conteudo) throws DocumentException {
        if (espacamento.length == conteudo.length) {
            PdfPTable tabela = montarTabela(espacamento.length, espacamento);
            PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();
            celula.setBackgroundColor(baseColor);

            for (String i : conteudo) {
                celula.setPhrase(new Phrase(i, FONTE_NORMAL_9));
                tabela.addCell(celula);

            }
            return tabela;
        }
        System.out.println("iText: valores diferentes entre colunas e conteudos");
        return new PdfPTable(espacamento.length);
    }

    public PdfPTable montarTabelaConteudoFundoCinza(int[] espacamento, String... conteudo) throws DocumentException {
        if (espacamento.length == conteudo.length) {
            PdfPTable tabela = montarTabela(espacamento.length, espacamento);
            PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();
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

    public PdfPTable montarTabelaTitulo(String conteudo) throws DocumentException {
        PdfPTable tabela = new PdfPTable(1);
        tabela.setWidths(new int[1]);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(5);
        PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

        celula.setPhrase(new Phrase(conteudo, FONTE_NEGRITO_9));
        tabela.addCell(celula);

        return tabela;
    }

    public PdfPCell montarCelulaColuna(String conteudo) {
        PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

        celula.setPhrase(new Phrase(conteudo, FONTE_NEGRITO_8));

        return celula;
    }

    public PdfPCell montarCelula(String conteudo, Font fonte) {
        PdfPCell celula = montarCelulaSemBordaAlinhamentoEsquerda();

        celula.setPhrase(new Phrase(conteudo, fonte));

        return celula;
    }

//    public void baixarRelatorio(String nomeArquivo) {
//        try {
//            String fileName = nomeArquivo;
//            // download
//            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(fileName)));
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            int x;
//            while ((x = in.read()) != -1) {
//                baos.write(x);
//            }
//            in.close();
//            byte[] b = baos.toByteArray();
//            HttpServletResponse response = (HttpServletResponse) JsfUtil.getFacesContext().getExternalContext().getResponse();
//            response.setContentType("application/pdf");
//            response.setHeader("Content-disposition", "attachment;filename=Ficha de Atendimento.pdf");
//            response.getOutputStream().write(b);
//            JsfUtil.getFacesContext().responseComplete();
//
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            //addError(ex.getMessage());
//        }
//    }
    public PdfPTable montarRodape(int x, int y, String nomeOperador, String nomeEstabelecimento) throws DocumentException {
        PdfPTable table = montarTabela(5, new int[]{3, 12, 3, 16, 3});
        table.setTotalWidth(527);
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(700);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.addCell(montarCelulaColuna("Operador: "));
        table.addCell(montarCelulaConteudo(nomeOperador));
        table.addCell(montarCelulaColuna("Unidade: "));
        table.addCell(montarCelulaConteudo(nomeEstabelecimento));
        table.addCell(montarCelula(x + " de " + y, ITextUtil_.FONTE_NEGRITO_9));
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        return table;
    }

    public PdfPTable montarRodapeLandscape(int x, int y, String nomeOperador, String nomeEstabelecimento) throws DocumentException {
        PdfPTable table = montarTabela(5, new int[]{5, 12, 5, 12, 3});
        table.setTotalWidth(767);
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(700);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.addCell(montarCelulaColuna("Operador: "));
        table.addCell(montarCelulaConteudo(nomeOperador));
        table.addCell(montarCelulaColuna("Unidade: "));
        table.addCell(montarCelulaConteudo(nomeEstabelecimento));
        table.addCell(montarCelula(x + " de " + y, ITextUtil_.FONTE_NEGRITO_9));
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        return table;
    }

    public String formatarDate(Date date, String pattern) {
        if (date != null) {
            return new SimpleDateFormat(pattern).format(date);
        } else {
            return "___/___/________";
        }
    }

//    public String formatarDateNascimento(Pessoa pessoa) {
//        if (pessoa.getDataNascimento() != null) {
//            return pessoa.getDataNascimentoString() + " (" + pessoa.getIdade()[0] + " anos)";
//        } else {
//            return "___/___/________";
//        }
//    }
//    public String cartaoCNS(Pessoa pessoa) {
//        if (pessoa.getCartaoCNS() != null && pessoa.getCartaoCNS().getNumero() != null && !pessoa.getCartaoCNS().getNumero().isEmpty()) {
//            return pessoa.getCartaoCNS().getNumero();
//        } else {
//            return "|__|__|__|__|__|__|__|__|__|__|__|__|__|__|__|";
//        }
//    }
//    public void montarCabecalhoERodape(ByteArrayOutputStream baos, OutputStream os, OperadorLogado operadorLogado, Municipio municipio, Relatorio relatorio) throws Exception {
//        PdfReader reader = new PdfReader(baos.toByteArray());
//        PdfStamper stamper = new PdfStamper(reader, os);
//        // Loop over the pages and add a header to each page
//        int n = reader.getNumberOfPages();
//        for (int i = 1; i <= n; i++) {
//            this.montarRodape(i, n, operadorLogado).writeSelectedRows(
//                    0, -1, 25, 25, stamper.getOverContent(i));
//
//            this.montarCabecalho(relatorio, municipio).writeSelectedRows(
//                    0, -1, 34, 825, stamper.getOverContent(i));
//
//            if (municipio.getImg() != null) {
//                this.montarFoto(municipio.getImg()).writeSelectedRows(
//                        0, -1, 34, 830, stamper.getOverContent(i));
//            }
//        }
//        stamper.close();
//        reader.close();
//    }
}
