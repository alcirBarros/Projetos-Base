package com.object;

public class equal {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(11, "Filipe");
        Pessoa pessoa2 = new Pessoa(12, "Nathan");
        Pessoa pessoa3 = new Pessoa(11, "Aline");
        Pessoa pessoa4 = new Pessoa(14, "Julia");
        
        
        boolean equals1 = pessoa1.equals(pessoa3);
        System.out.println(equals1);
        
    }

}
