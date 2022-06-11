package org.example.views.menus;

import java.util.Scanner;

public class TransferMenu extends BasicMenu {
    public String printMenu(Scanner sc){
        System.out.println("Digite:\n0 - Sair da transferência\n1 - Sacar\n2 - Depositar");
        System.out.print("Opcao: ");
        String option = sc.nextLine();

        return option;
    }

    public static void exit() {
        System.out.println("Voltando para o menu do cliente");
    };
}
