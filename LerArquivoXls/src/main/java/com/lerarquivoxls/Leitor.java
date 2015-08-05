package com.lerarquivoxls;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Leitor {
    
    public List<List> lerPLanilha(File file) throws Exception {
        FileInputStream arquivo = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
        XSSFSheet planilha = workbook.getSheetAt(0);
        Iterator<Row> linhas = planilha.iterator();
        List<List> registroList = new ArrayList<>();
        
        while (linhas.hasNext()) {
            Row linha = linhas.next();
            Iterator<Cell> cellIterator = linha.cellIterator();

            List<Object> registro = new ArrayList();
            
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        registro.add(cell.getStringCellValue());
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        registro.add(cell.getNumericCellValue());
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        registro.add(cell.getBooleanCellValue());
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default:
                }
            }
            registroList.add(registro);
            System.out.println("");
        }
        return registroList; 
    }
}
