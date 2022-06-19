package org.example.views.show;

import org.example.repository.RepositoryUsers;

public class ShowAllClients {
    public static void run() {
        System.out.println();
        header();
        RepositoryUsers.getClientList().forEach(System.out::print);
        System.out.println();
    }

    private static void header() {
        System.out.printf("%-30s %-15s %-20s %-30s %-20s%n", "Nome", "CPF", "Saldo", "Tipo de investidor", "Numero da conta");
    }
}
