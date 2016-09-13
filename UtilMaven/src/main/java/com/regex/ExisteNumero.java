package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExisteNumero {
    
    public static void main(String[] args) {
        boolean b = existePeloMenosUmNumeroNaString("aaa234567");
        System.err.println(b);
    }

    public static boolean existePeloMenosUmNumeroNaString(String str) {
        Pattern pat = Pattern.compile("\\d");
        Matcher matcher = pat.matcher(str);
        return matcher.find();
    }
}
