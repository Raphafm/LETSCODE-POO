package org.example.views;
import java.util.Scanner;

abstract class BasicMenu {
    abstract String printMenu(Scanner sc);

    public static void exit() {
        System.out.println("Saindo da Conta e voltando para o menu principal");
    };

    public static void invalidOption(){
        System.err.println("Opção inválida, digite novamente");
    }
}
