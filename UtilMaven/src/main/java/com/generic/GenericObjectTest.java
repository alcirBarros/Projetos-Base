package com.generic;

//http://compoune.com/q/68554/diferen%C3%A7as-entre-t-e
public class GenericObjectTest {

    public static void main(String[] args) {
        GenericObject<?> mg = new GenericObject<>(12.1);
        
        Object var = mg.getVar();
        
        System.out.println(var);
    }
}

class GenericObject<T> {  //T abreviacao de tipo

    private T var;

    public GenericObject() {
    }

    public GenericObject(T var) {
        this.var = var;
    }

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}
