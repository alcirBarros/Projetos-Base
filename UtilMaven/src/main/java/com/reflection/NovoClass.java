package com.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class NovoClass {
    
    public static void main(String[] args) {
        
    }

    public void capitalizarAtributosString(Object obj, String... excessoes) {
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            List<String> excessoesList = Arrays.asList(excessoes);
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.getType().equals(String.class) && !excessoesList.contains(field.getName())) {

                    String campoString = (String) field.get(obj);
                    if (campoString != null) {
                        field.set(obj, campoString.toUpperCase());

                    }

                }
            }
        } catch (Exception e) {
        }
    }
}
