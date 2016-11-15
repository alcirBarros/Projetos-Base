package com.clone;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassUtil {

    public static void main(String[] args) {
        try {
            Pessoa pessoa = new Pessoa();
            List headerCampos = getHeaderCampos(pessoa.getClass());
            System.out.println(headerCampos);
            List campos = getCampos(pessoa);
            System.out.println(campos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static List getHeaderCampos(Class<?> classe) {
        List campos = new ArrayList();
        Field[] declaredFields = classe.getDeclaredFields();
        for (Field field : declaredFields) {
            campos.add(field.getName());
        }
        return campos;

    }

    private static List getCampos(Object obj) throws IllegalArgumentException, IllegalAccessException {
        List campos = new ArrayList();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.getType().equals(Date.class)) {
                Object value = field.get(obj);
                campos.add(value);
            } else {
                campos.add(field.get(obj));

            }
        }
        return campos;
    }

}
