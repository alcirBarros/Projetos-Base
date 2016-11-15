package com.scanner;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String args[]) {
        System.out.print("Digite seu nome: ");
        Scanner entrada = new Scanner(System.in);
        String nome = entrada.nextLine();
        System.out.println("O nome digitado foi: " + nome);
    }
}
