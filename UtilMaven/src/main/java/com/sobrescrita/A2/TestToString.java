package com.sobrescrita.A2;


public class TestToString {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        int hashCode = myClass.hashCode();
        System.err.println(hashCode);
    }
}
