package org.example.views;

import org.example.model.Client;


public class ShowAccount {
    public static void run(Client client) {
        System.out.printf("Cliente: %s %n", client.getNome());
        System.out.printf("Agência: %s %n", Client.getAGENCIA());
        System.out.printf("Conta: %s %n", client.getAccountNumber());
        System.out.printf("Perfil do investidor: %s %n", client.getTypeInvestorProfile());
        System.out.println("-----------------------------------------------------------------");
    }
}
