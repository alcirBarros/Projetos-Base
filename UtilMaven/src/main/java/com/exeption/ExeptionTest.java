package com.exeption;

public class ExeptionTest {

    public static void main(String[] args) {
        try {
            String exeption = exeption(null);
            System.out.println(exeption);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static String exeption(String a) throws Exception {
        try {
            return a.toString();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            return "finally";
        }
    }
}
