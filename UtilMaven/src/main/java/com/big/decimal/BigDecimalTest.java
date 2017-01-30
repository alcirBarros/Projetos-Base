package com.big.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void compareitorValueMenor() {
        BigDecimal myBigDecimal = new BigDecimal(0);
        BigDecimal bigBigDecimal = new BigDecimal(1);
        if (myBigDecimal.compareTo(bigBigDecimal) == -1) {
            System.out.println(myBigDecimal + " < " + bigBigDecimal);
        }
    }

    public static void compareitorValuesIquals() {
        BigDecimal smallBigDecimal = new BigDecimal(1);
        BigDecimal bigBigDecimal = new BigDecimal(1);
        if (smallBigDecimal.compareTo(bigBigDecimal) == 0) {
            System.out.println(smallBigDecimal + "==" + bigBigDecimal);
        }
    }

    public static void compareitorValueMaior() {
        BigDecimal myBigDecimal = new BigDecimal(10);
        BigDecimal bigBigDecimal = new BigDecimal(1);
        if (myBigDecimal.compareTo(bigBigDecimal) == 1) {
            System.out.println(myBigDecimal + " > " + bigBigDecimal);
        }
    }

    public static void arredondamento() {
        double value = 1.6987654;
        int scale = 10;
        BigDecimal bd = new BigDecimal(value);
        BigDecimal setScale = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
        System.out.println(value);
        System.out.println(bd);
        System.out.println(setScale);
        System.out.println("-------------");
        System.out.println(bd.setScale(1, RoundingMode.UP));
        System.out.println(bd.setScale(2, RoundingMode.UP));
        System.out.println(bd.setScale(3, BigDecimal.ROUND_CEILING));
        System.out.println(bd.setScale(4, BigDecimal.ROUND_DOWN));
        System.out.println(bd.setScale(5, BigDecimal.ROUND_FLOOR));
        System.out.println(bd.setScale(6, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(bd.setScale(7, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(bd.setScale(8, BigDecimal.ROUND_HALF_UP));
        //System.out.println(bd.setScale(scale, BigDecimal.ROUND_UNNECESSARY));
        System.out.println(bd.setScale(9, BigDecimal.ROUND_UP));
        System.out.println(bd.setScale(scale, BigDecimal.ROUND_UP));

    }

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal(1.134);
        BigDecimal valor = bd.setScale(2, RoundingMode.HALF_UP);
        System.err.println(valor);
    }
}
