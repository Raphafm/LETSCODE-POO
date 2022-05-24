package org.example.Menus;

import java.util.Scanner;
import org.example.simulacao.Simulacao;

public class Menus {
    private static final Scanner sc = new Scanner(System.in);
    private static String opcao;

    public static void menuPrincipal() {

        System.out.println("Bem vindo ao menu principal");
        System.out.println("Digite:\n0 - Sair\n1 - Fazer o login\n2 - Criar conta\n3 - Fazer simulação");
        opcao = sc.nextLine();

        switch (opcao) {
            case "0":
                System.out.println("Obrigado por utilizar nossos serviços, até a próxima");
                return;
            case "1":
                System.out.println("Login");
                break;
            case "2":
                System.out.println("Criar conta");
                break;
            case "3":
                System.out.println("simulação");
                Scanner ler = new Scanner(System.in);
                //quantia sera pega do titulo por switch?
                System.out.print("Insira o juros anual: ");
                double JurosAnual = ler.nextFloat();
                Simulacao investimento = new Simulacao(JurosAnual);
                investimento.relatorio();
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        menuPrincipal();
    }

    public static void menuCliente() {
        System.out.println("Bem vindo ao menu do cliente");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Tirar o extrato\n2 - Realizar uma transferência\n3 - Investir");
        opcao = sc.nextLine();

        switch (opcao) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.println("extrato");
                break;
            case "2":
                System.out.println("transferencia");
                break;
            case "3":
                System.out.println("investir");
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        menuCliente();
    }

    public static void menuCorretora() {
        System.out.println("Bem vindo ao menu da corretora");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Cadastrar produto\n2 - Atualizar produto");
        System.out.println("3 - Obter Relatório\n4 - Obter arrecadação");
        opcao = sc.nextLine();

        switch (opcao) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.println("Cadastrar produto");
                break;
            case "2":
                System.out.println("Atualizarproduto");
                break;
            case "3":
                System.out.println("Obter relatorio");
                break;
            case "4":
                System.out.println("Obter arrecadação");
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        menuCorretora();
    }
}
