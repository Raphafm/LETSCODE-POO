package org.example.views.menus;

import org.example.model.Cores;


abstract class BasicMenu {
    // abstract String printMenu(Scanner sc);

    public static void exit() {
        System.out.println(Cores.RED);
        System.out.println("Saindo da Conta e voltando para o menu principal");
        System.out.println(Cores.RESET);
    }

    public static void invalidOption(){
        System.out.println(Cores.RED);
        System.out.println("Opção inválida, digite novamente");
        System.out.println(Cores.RESET);
    }
}
