package com.enumerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum EnumClass {
    
    COLUMN_A("A"),
    COLUMN_B("B"),
    COLUMN_C("C"),
    COLUMN_D("D"),
    COLUMN_E("E");

    public static EnumClass[] removeAll(EnumClass[] enumList) {
        List<EnumClass> enumList_ = new ArrayList<>();
        List<EnumClass> enumRemoverList = Arrays.asList(enumList);
        List<EnumClass> asList = Arrays.asList(EnumClass.values());
        for (EnumClass enumClass : asList) {
            if(!enumRemoverList.contains(enumClass)){
                enumList_.add(enumClass);
            }
        }
        return enumList_.toArray(new EnumClass[enumList_.size()]);
    }
    
    private final String value;

    private EnumClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}