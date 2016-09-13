package com.regex;

public class RemoveCarateresEspeciais {

    public static void main(String[] args) {
        String string = removeCaracteresEspeciais("AAA&%$@! @#$%*BB1234567");
        System.err.println(string);
    }
    
    public static String removeCaracteresEspeciais(String texto) {
        String[] caracteresEspeciais = {"\\.", ",", "-", ":", ";", "\\(", "\\)", "ª", "\\|", "\\\\", "°", "'", "@", "!"};
        for (int i = 0; i < caracteresEspeciais.length; i++) {
            texto = texto.replaceAll(caracteresEspeciais[i], "");
        }
        return texto;
    }

    
}
