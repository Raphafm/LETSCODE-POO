package org.example.Menus;

import java.util.Scanner;

public class MenuCliente {
    public static void menuCliente(Scanner sc) {
        System.out.println("Bem vindo ao menu do cliente");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Tirar o extrato\n2 - Realizar uma transferência\n3 - Investir");
        System.out.print("Opcao: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.println("extrato em construção");
                break;
            case "2":
                System.out.println("transferencia em construção");
                break;
            case "3":
                System.out.println("investir em construção");
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        menuCliente(sc);
    }
}
