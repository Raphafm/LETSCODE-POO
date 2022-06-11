package org.example.views.menus;
import java.util.Scanner;


public class MainMenu extends BasicMenu {
    public String printMenu(Scanner sc) {

        System.out.println("Bem vindo ao menu principal");
        System.out.println("Digite:\n0 - Sair\n1 - Fazer o login\n2 - Criar conta\n3 - Fazer simulação");
        System.out.print("Opcao: ");
        String option = sc.nextLine();
        return option;
    }

    public static void exit(){
        System.out.println("Obrigado por usar o nosso serviço, até a próxima!");
    }

}
