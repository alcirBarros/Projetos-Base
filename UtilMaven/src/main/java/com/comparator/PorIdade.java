package com.comparator;

import java.util.Comparator;

public class PorIdade implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return p1.idade.compareTo(p2.idade);
    }

}
