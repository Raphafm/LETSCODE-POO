package org.example.views.menus;
import java.util.Scanner;

public class ClientMenu extends BasicMenu {
    public static String printMenu(Scanner sc) {
        System.out.println("Bem vindo ao menu do cliente");
        System.out.println("Digite:");
        System.out.println("\t0 - Sair da conta");
        System.out.println("\t1 - Tirar o extrato");
        System.out.println("\t2 - Realizar uma transferência");
        System.out.println("\t3 - Investir");
        System.out.print("Opcao: ");

        return sc.nextLine();
    }
}
