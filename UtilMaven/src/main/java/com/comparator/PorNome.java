package com.comparator;

import java.util.Comparator;

public class PorNome implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return p1.nome.compareTo(p2.nome);
    }

}
