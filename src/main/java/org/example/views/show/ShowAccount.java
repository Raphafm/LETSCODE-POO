package org.example.views.show;

import org.example.model.Client;


public class ShowAccount {
    public static void run(Client client) {
        System.out.printf("Cliente: %s %n", client.getName());
        System.out.printf("Agência: %s %n", Client.getAGENCY());
        System.out.printf("Conta: %s %n", client.getAccountNumber());
        System.out.printf("Perfil do investidor: %s %n", client.getTypeInvestorProfile());
        System.out.println("-----------------------------------------------------------------");
    }
}
