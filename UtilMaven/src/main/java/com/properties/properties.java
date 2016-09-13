package com.properties;

import java.util.Properties;

public class properties {

    public static void main(String[] args) {
        Properties p = System.getProperties();
        p.list(System.out);
    }

}
