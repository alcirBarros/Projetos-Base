package com.string;

import java.text.Normalizer;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class StringTeste {
    
    public static void main(String[] args) {
        mainJoin(args);
    }

    public static void normalizer(String[] args) {
        String str = "maçã";
        String replaceAll = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        System.err.println(replaceAll);
    }

    
    public static void mainJoin(String[] args) {
        String join = StringUtils.join(Arrays.asList(0, 1, 2, 3), "|");
        System.out.println(join); //0|1|2|3
    }

}
