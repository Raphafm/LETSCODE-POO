package org.example.views;

import org.example.model.Client;

import java.util.Scanner;

public class TransferMenu {
    public static String transferMenu(Scanner sc){
        System.out.println("Digite:\n0 - Sair da transferência\n1 - Sacar\n2 - Depositar");
        System.out.print("Opcao: ");
        String option = sc.nextLine();

        return option;
    }

    public static void exit(){
        System.out.println("Saindo da transferência e voltando para o menu do Client");
    }

    public static void invalidOption(){
        System.out.println("Opção inválida, digite novamente");
    }
}
