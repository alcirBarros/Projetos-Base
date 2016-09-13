package com.sobrescrita.A2;

public class MyClass {

    private Integer integer;

    @Override
    public boolean equals(Object obj) {
        System.err.println("A");
        return true;
    }

    boolean equals(Integer obj) {
        System.err.println("B");
        return true;
    }

}
