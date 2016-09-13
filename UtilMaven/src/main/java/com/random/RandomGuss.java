package com.random;

import java.util.Random;

public class RandomGuss {

    public static void main(String[] args) {
//        System.out.println(UUID.randomUUID().toString().substring(0, 8));
//        System.out.println(new Random().nextInt(10));

        Random rand = new Random();
        while (true) {
            int randomNum = rand.nextInt((10 - 5) + 1) + 5;
            System.out.println(randomNum);
        }
    }

    private static double randomValorUnitario() {
        double MEAN = 100.0f;
        double VARIANCE = 5.0f;
        double valor = (MEAN + new Random().nextGaussian() * VARIANCE);
        return valor;
    }
}
