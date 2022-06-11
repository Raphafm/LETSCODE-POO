package org.example.views;
import org.example.model.Client;
import org.example.views.AcessTransfer;
import java.util.Scanner;

public class ClientMenu {
    public static void clientMenu(Scanner sc, Client cliente) {
        System.out.println("Bem vindo ao menu do cliente");
        System.out.println("Digite:");
        System.out.println("\t0 - Sair da conta");
        System.out.println("\t1 - Tirar o extrato");
        System.out.println("\t2 - Realizar uma transferência");
        System.out.println("\t3 - Investir");
        System.out.print("Opcao: ");
        String option = sc.nextLine();

        switch (option) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.print(cliente.printExtract());
                break;
            case "2":
                System.out.println("transferência em construção");
                transferMenu(sc, cliente);
                break;
            case "3":
                System.out.println("investir em construção");
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        clientMenu(sc, cliente);
    }
    public static void transferMenu(Scanner sc, Client client){
        System.out.println("Digite:");
        System.out.println("\t0 - Sair da transferência");
        System.out.println("\t1 - Sacar");
        System.out.println("\t2 - Depositar");
        System.out.print("Opcao: ");
        String option = sc.nextLine();
        switch (option) {
            case "0":
                System.out.println("Saindo da transferência e voltando para o menu do Client");
                return;
            case "1":
                client.withdraw(AcessTransfer.run(sc));
                break;
            case "2":
                client.deposit(AcessTransfer.run(sc));
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                transferMenu(sc, client);
        }
    }
}
