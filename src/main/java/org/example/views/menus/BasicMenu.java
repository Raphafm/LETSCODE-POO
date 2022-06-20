package org.example.views.menus;
import org.example.model.TextColors;
import java.util.Scanner;

public abstract class BasicMenu {

    public abstract String printMenu(Scanner sc);

    public static void exit() {
        System.out.println(TextColors.RED);
        System.out.println("Saindo da Conta e voltando para o menu principal");
        System.out.println(TextColors.RESET);
    }

    public static void invalidOption(){
        System.out.println(TextColors.RED);
        System.out.println("Opção inválida, digite novamente");
        System.out.println(TextColors.RESET);
    }
}
