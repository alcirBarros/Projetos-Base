package com.comparator;

import java.util.List;
import java.util.TreeSet;

public class Teste {

    public static void main(String[] args) {
        TreeSet<Pessoa> treeSetList = new TreeSet<>(new PorIdade());        
        treeSetList.add(new Pessoa("pedro", 34));
        treeSetList.add(new Pessoa("lorena", 2));
        treeSetList.add(new Pessoa("kike", 5));
        treeSetList.add(new Pessoa("juliane", 32));
        
 
        
        System.out.println("ordem de idade -" + treeSetList);

    }
}
