package com.sobrecarga;

public class Teste {
    
    public static void main(String[] args) {
        Animal animal = new Cavalo();
        
        Cavalo cavalo = (Cavalo) animal;
        cavalo.comer(Integer.BYTES);
        
    }
    
}
