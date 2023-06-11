package com.studies.silvabankapi;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Olá, boas-vindas ao Silva Bank.");
        Scanner sc = new Scanner(System.in);

        System.out.println("Gostaria de abrir uma conta? Digite SIM ou NAO.");
        String newAccount = sc.nextLine();

        AccountOpening accountOpening = new AccountOpening();

        if(Objects.equals(newAccount, "SIM")) {
            accountOpening.openAccount();
        } else if(Objects.equals(newAccount, "NAO")) {
            System.out.println("Ok, obrigado.");
        }


        sc.close();
    }
}