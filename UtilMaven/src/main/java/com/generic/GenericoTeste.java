package com.generic;

import java.math.BigInteger;

//http://compoune.com/q/68554/diferen%C3%A7as-entre-t-e
public class GenericoTeste {

    public static void main(String[] args) {
        Generico<? super Number> mg = new Generico();
        //escrevendo em uma variável
        mg.setVar(new Integer(1));                      //válido
        mg.setVar(new Float(2.0f));                     //válido
        mg.setVar(new BigInteger("99999999999999"));    //válido
        //mg.setVar(new String("999999999"));           //inválido!!
        Number var = (Number) mg.getVar();
        System.out.println(var);
    }

}

class Generico<T> {  //T abreviacao de tipo

    private T var;

    public Generico() {
    }

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}
