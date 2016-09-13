package com.gson;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

//http://blog.wektabyte.com/converter-objetos-java-em-json-e-vice-versa-com-gson/
public class GsonTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        
        list.add(new User("Wagner", 24));
        
        String toJson = new Gson().toJson(list);
        System.out.println(toJson);
        
    }
}
