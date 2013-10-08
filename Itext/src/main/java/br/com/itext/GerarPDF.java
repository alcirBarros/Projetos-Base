package br.com.itext;

import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarPDF {

    public static void main(String[] args) throws Exception {
        Document doc = null;
        OutputStream os = null;

        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4.rotate(), 72, 72, 72, 72);

            //cria a stream de saída
            os = new FileOutputStream("out.pdf");

            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);

            //abre o documento
            doc.open();

            //adiciona o texto ao PDF
            
            {
            PdfPTable tabela = new PdfPTable(4);
            
            PdfPCell cell = new PdfPCell();
            cell.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
            
            cell.setPhrase(new Phrase("Teste1"));
            tabela.addCell(cell);
            
            cell.setPhrase(new Phrase("Teste2"));
            tabela.addCell(cell);
            
            cell.setPhrase(new Phrase("Teste3"));
            tabela.addCell(cell);
            
            cell.setPhrase(new Phrase("Teste4"));
            tabela.addCell(cell);
            
            doc.add(tabela);
            }

            PdfPTable tabela = new PdfPTable(3);
            tabela.setWidthPercentage(100);
            tabela.setSpacingBefore(1);
            tabela.setWidths(new int[]{8, 92, 10});

            PdfPCell celula = new PdfPCell();
            celula.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celula.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celula.setPhrase(new Phrase("FICHA B - GES"));
            
            tabela.addCell(celula);
            
            
            
            
            
            PdfPCell celula2 = new PdfPCell();
            celula2.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celula2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celula2.setBackgroundColor(BaseColor.GRAY);
            
            Phrase phrase = new Phrase();
            phrase.add("SECRETARIA MUNICIPAL DE SAÚDE ATENÇÃO BÁSICA - SAÚDE DA FAMÍLIA");
            
            Font font = new Font();
            font.setSize(9);
            
            phrase.setFont(font);
            celula2.setPhrase(phrase);
            tabela.addCell(celula2);
            
            PdfPCell celula3 = new PdfPCell();
            celula3.setPhrase(new Phrase("ANO"));
            tabela.addCell(celula3);
            
            tabela.setSpacingBefore(5);


            doc.add(tabela);
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
    }
}
