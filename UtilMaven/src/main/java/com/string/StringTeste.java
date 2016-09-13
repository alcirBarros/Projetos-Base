package com.string;

import java.text.Normalizer;

public class StringTeste {

    public static void main(String[] args) {
        String str = "maçã";
        String replaceAll = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        System.err.println(replaceAll);
    }
}
