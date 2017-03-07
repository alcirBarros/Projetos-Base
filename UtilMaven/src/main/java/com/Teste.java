package com;

/**
 *
 * @author alci
 */
public class Teste {
    public static void main(String[] args) {
        
        EnumClass enumClass = EnumClass.DETALHADO;
        
        switch (enumClass){
            case SINTETICO :{
                System.out.println("AAAAAAAAAAA");
            }
            default:{
                System.out.println("DEFALT");
            }
        }
    }
    
    public enum EnumClass{
        SINTETICO,
        DETALHADO,
    }
}
