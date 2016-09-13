package com.reflection;


public class Reflection {

    public static void main(String[] args) {
        try {
            String typeName = Reflection.class.getTypeName();
            Object obj = Class.forName(typeName).newInstance();
            System.err.println(obj);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
