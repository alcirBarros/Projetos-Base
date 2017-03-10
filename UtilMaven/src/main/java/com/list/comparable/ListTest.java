package com.list.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ListTest {

    public static void main(String[] args) {
        createList();
    }

    public static void createSet() {
        Set<Conta> contaList = new HashSet<>();
        contaList.add(new Conta("Luiz", 4566));
        contaList.add(new Conta("Carlos", 457));
        contaList.add(new Conta("Carlos", 457));
        contaList.add(new Conta("Carlos", 457));
        contaList.add(new Conta("Carlos", 457));

        System.out.println(contaList);
    }

    public static void createList() {
        List<Conta> contaList = new ArrayList<>();
        contaList.add(new Conta("Carlos", 457));
        contaList.add(new Conta("Wagner", 54334));
        contaList.add(new Conta("Luiz", 4566));
        contaList.add(new Conta("Paulo", 345));

        System.out.println("Não Ordenado: " + contaList);

        Collections.sort(contaList);
        System.out.println("Ordenado pela classe: " + contaList);

        Conta.titular titular = new Conta.titular();
        Collections.sort(contaList, titular);
        System.out.println("Ordenado pelo titular: " + contaList);

        Conta.numeroConta numeroConta = new Conta.numeroConta();
        Collections.sort(contaList, numeroConta);
        System.out.println("Ordenado por número da conta:" + contaList);

    }

}

class Conta implements Comparable<Conta> {

    private String titular;
    private Integer numeroConta;

    public Conta() {
    }

    public Conta(String titular, Integer numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public int compareTo(Conta o) {
        return this.numeroConta.compareTo(o.numeroConta);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Conta:").append(titular).append(",").append(numeroConta).toString();
    }

    public static class titular implements Comparator<Conta> {

        @Override
        public int compare(Conta conta, Conta outraConta) {
            return conta.getTitular().compareTo(outraConta.getTitular());
        }
    }

    public static class numeroConta implements Comparator<Conta> {

        @Override
        public int compare(Conta conta, Conta outraConta) {
            return conta.getNumeroConta().compareTo(outraConta.getNumeroConta());
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.titular);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        return true;
    }

}
