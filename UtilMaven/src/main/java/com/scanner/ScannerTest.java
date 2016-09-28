package com.scanner;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.println("O nome digitado foi: " + nome);
    }
}
