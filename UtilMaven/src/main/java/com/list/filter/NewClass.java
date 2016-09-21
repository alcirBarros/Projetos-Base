package com.list.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

public class NewClass {

    public static void main(String[] args) {



        String[] stringArray = {""};

        String[] orElse = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null && !p.trim().equals("")).toArray(String[]:: new))).orElse(null);

        System.out.println(orElse);
        
        //String[] toArray = Arrays.asList(stringArray).stream().filter(p -> p != null).toArray(size -> new String[size]);
        //String[] orElse = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null).toArray(size -> new String[size]))).orElse(new String[]{});
        //Optional<Object[]> get = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null).toArray()));
        //if (get.isPresent()) {
        //    Arrays.asList(get).stream().forEach(System.out::println);
        //}
    }
}
