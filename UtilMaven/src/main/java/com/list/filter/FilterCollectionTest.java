package com.list.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilterCollectionTest implements Predicate<Pessoa>{

    public static void main(String[] args) {

        List<Pessoa> pessoaList = new ArrayList<Pessoa>();
        pessoaList.add(new Pessoa(12, Sexo.MALE));
        pessoaList.add(new Pessoa(15, Sexo.MALE));
        pessoaList.add(new Pessoa(31, Sexo.FEMALE));
        pessoaList.add(new Pessoa(44, Sexo.MALE));

        Predicate<Pessoa> validPersonPredicate = new Predicate<Pessoa>() {
            public boolean apply(Pessoa person) {
                return person.getIndade() > 21 && person.getSex() == Sexo.MALE;
            }
        };

        Collection<Pessoa> result = filter(pessoaList, validPersonPredicate);

        System.out.println(result);

    }

    public static <T> Collection<T> filter(Collection<T> col, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<T>();
        for (T element : col) {
            if (predicate.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public boolean apply(Pessoa type) {
        return type.getIndade() > 21 && type.getSex() == Sexo.MALE;
    }

}

interface Predicate<T> {

    boolean apply(T type);
}


