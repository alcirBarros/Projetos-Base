package com.lerarquivoxls;

import java.io.File;
import javax.swing.JFileChooser;

public class AbrirArquivoXls {

    public static File abrirArquivo() {
        JFileChooser chooser = new JFileChooser();
        chooser.showDialog(chooser, "Selecionar");
        File arquivo = chooser.getSelectedFile();
        return arquivo;
    }

}
