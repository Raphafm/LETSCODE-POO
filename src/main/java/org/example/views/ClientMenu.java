package org.example.views;
import org.example.model.Client;
import org.example.views.AcessTransfer;
import java.util.Scanner;

public class ClientMenu extends BasicMenu{
    public String printMenu(Scanner sc) {
        System.out.println("Bem vindo ao menu do cliente");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Tirar o extrato\n2 - Realizar uma transferência\n3 - Investir");
        System.out.print("Opcao: ");
        String option = sc.nextLine();

        return option;
    }

}
