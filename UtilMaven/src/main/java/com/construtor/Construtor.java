package com.construtor;

public class Construtor {

    static {
        System.out.println("11111111111111111111111111111111111111");
    }

    static {
        System.out.println("222222222222222222222222222222222222");
    }

    {
        System.out.println("33333333333333333333");
    }

    public static void teste() {
        System.out.println("teste");
    }

    public Construtor() {
        System.out.println("44444444444444444");
    }

    public static void main(String[] args) {
        Construtor.teste();
    }
}
