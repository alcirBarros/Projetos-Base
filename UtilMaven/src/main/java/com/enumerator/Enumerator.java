package com.enumerator;

public class Enumerator {

    public static void main(String[] args) {
        
        EnumClass[] enumClasseArray = new EnumClass[]{EnumClass.COLUMN_A, EnumClass.COLUMN_B, EnumClass.COLUMN_C, EnumClass.COLUMN_D, EnumClass.COLUMN_E};

        EnumClass[] removeAll = EnumClass.removeAll(enumClasseArray);


        System.out.println(removeAll);
        
    }
}

