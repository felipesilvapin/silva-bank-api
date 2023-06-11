package com.studies.silvabankapi;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class AccountOpening {
    public void openAccount() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        Customer customer = new Customer();
        String cep = "";
        String cpf = "";

        System.out.println("Vamos abrir sua conta. Por gentileza, digite o seu nome completo:");
        customer.setName(sc.nextLine());

        System.out.println("Legal. Agora, digite o seu CPF:");
        cpf = sc.nextLine();
        while (cpf.length() < 11) {
            System.out.println("Por gentileza, digite um CPF válido");
            cpf = sc.nextLine();
        }
        customer.setCpf(cpf);

        System.out.println("Por gentileza, digite o CEP do seu endereço:");
        cep = sc.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        AddressKeys addressKeys = gson.fromJson(response.body(), AddressKeys.class);
        Address address = new Address(addressKeys);

        account.setHolder(customer);
        int numberAgency = 4;
        int numberAccount = 6;

        for (int i = 0; i < numberAgency; i++) {
            double randomNum = Math.floor(Math.random() * 10000.0);
            account.setAgency((int) randomNum);
        }

        for (int i = 0; i < numberAccount; i++) {
            double randomNum = Math.floor(Math.random() * 1000000.0);
            account.setAccount((int) randomNum);
        }

        System.out.println("Nome: " + account.getHolder().getName());
        System.out.println("CPF: " + account.getHolder().getCpf());
        System.out.println("Endereço: Rua " + address.getLogradouro() +  ", bairro: " + address.getBairro()
                + ", cidade: " + address.getLocalidade()
                + ", UF do estado: " + address.getUf());
        System.out.println("Agencia: " + account.getAgency());
        System.out.println("Conta: " + account.getAccount());

        System.out.println("--------------------------------");


        sc.close();
    }

}
