package org.example.views.menus;

import org.example.model.Cores;

import java.util.Scanner;

public class MainMenu extends BasicMenu {
    public String printMenu(Scanner sc) {
        System.out.println("Bem vindo ao menu principal");
        System.out.println("Digite:");
        System.out.println("\t0 - Sair");
        System.out.println("\t1 - Fazer o login");
        System.out.println("\t2 - Criar conta");
        System.out.println("\t3 - Fazer simulação");
        System.out.print("Opcao: ");
        return sc.nextLine();
    }

    public static void exit() {
        System.out.println("Obrigado por usar o nosso serviço, até a próxima!");
    }

    public static void nonExistentUser() {
        System.out.println(Cores.RED);
        System.out.println("Usuario não encontrado!");
        System.out.println(Cores.RESET);
    }

}
