package com.sobrescrita.A1;

public class Animal implements Comportamento {

    public Animal() {
        System.out.println("com.sobrescrita.Animal.<init>()");
    }
    
    

    public Animal eat()  {
        System.err.println("Animal");
        return new Animal();
    }

    @Override
    public void andar() {
        System.err.println("Comportamento Animal");
    }

    
    public Animal andar(String s) throws Exception {
        return null;
    }

}
