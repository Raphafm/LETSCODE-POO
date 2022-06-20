package org.example.views.menus;

import org.example.model.TextColors;

import java.util.Scanner;

public class TransferMenu extends BasicMenu {
    public String printMenu(Scanner sc) {
        System.out.println("Digite:");
        System.out.println("\t0 - Sair da transferência");
        System.out.println("\t1 - Sacar");
        System.out.println("\t2 - Depositar");
        System.out.print("Opcao: ");
        return sc.nextLine();
    }

    public static void exit() {
        System.out.println(TextColors.RED);
        System.out.println("Voltando para o menu do cliente");
        System.out.println(TextColors.RESET);
    }
}
