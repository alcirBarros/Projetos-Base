package com.format;

import java.text.DecimalFormat;

public class NumericFormat extends Local {

    public static final String NUMERIC_PATTERN = "#,###.00000";

    public static String numberformat(double x) {
        DecimalFormat decimalFormat = new DecimalFormat(NUMERIC_PATTERN);
        return decimalFormat.format(x);
    }

    public static void main(String[] args) {
        String numberformat = NumericFormat.numberformat(24424122);
        System.err.println(numberformat);
    }
}
