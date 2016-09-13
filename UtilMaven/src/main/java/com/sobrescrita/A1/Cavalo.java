package com.sobrescrita.A1;

class Cavalo extends Animal implements Comportamento {
    
    

    Cavalo() {
        System.err.println("aaaaaaaaaaaaaa");
    }

    @Override
    public Animal eat() {
        return null;
    }

    @Override
    public void andar() {
        System.err.println("Galopa");
    }

}
