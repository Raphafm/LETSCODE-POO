package org.example.Menus;

import org.example.Model.Cliente;
import org.example.Telas.AcessarTransferencia;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuCliente {
    public static void menuCliente(Scanner sc, Cliente cliente) {
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
                System.out.print(cliente.imprimirExtrato());
                break;
            case "2":
                System.out.println("transferência em construção");
                menuTransferencia(sc, cliente);
                break;
            case "3":
                System.out.println("investir em construção");
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        menuCliente(sc, cliente);
    }
    public static void menuTransferencia (Scanner sc, Cliente cliente){
        System.out.println("Digite:\n0 - Sair da transferência\n1 - Sacar\n2 - Depositar");
        System.out.print("Opcao: ");
        String opcao = sc.nextLine();
        switch (opcao) {
            case "0":
                System.out.println("Saindo da transferência e voltando para o menu do Cliente");
                return;
            case "1":
                System.out.println("Sacar em construção");
                cliente.sacar(AcessarTransferencia.executar(sc));
                break;
            case "2":
                System.out.println("Depositar em construção");
                cliente.depositar(AcessarTransferencia.executar(sc));
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                menuTransferencia (sc, cliente);
        }
    }
}
