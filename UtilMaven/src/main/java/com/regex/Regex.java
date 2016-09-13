package com.regex;

import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {
        String input = "AA BB CC";
        Scanner s = new Scanner(input).useDelimiter("\\s");
        while (s.hasNext()) {
            String next = s.next();
            System.err.println(next);
        }
        s.close();
    }
}
