package com.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pessoa {

    public String nome;

    public Integer idade;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return String.format("%1$s – %2$d", this.nome, this.idade);
    }

    public static void ordenaPorIndade(List<Pessoa> list) {
        Collections.sort(list, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.idade.compareTo(o2.idade);
            }
        });
    }
}
