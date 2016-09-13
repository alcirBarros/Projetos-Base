package com.object;

import java.util.Objects;

public class hashCode {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(11, "Filipe");
        Pessoa pessoa2 = new Pessoa(12, "Nathan");
        Pessoa pessoa3 = new Pessoa(11, "Filipe");
        Pessoa pessoa4 = new Pessoa(14, "Filipe");
        
        
        int hashCode1 = pessoa1.hashCode();
        System.out.println(hashCode1);
        
        int hashCode2 = pessoa2.hashCode();
        System.out.println(hashCode2);
        
        int hashCode3 = pessoa3.hashCode();
        System.out.println(hashCode3);
        
        int hashCode4 = pessoa4.hashCode();
        System.out.println(hashCode4);
    }
}
