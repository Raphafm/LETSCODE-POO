package org.example.Menus;

import java.util.Objects;
import java.util.Scanner;

import org.example.Telas.AcessarConta;
import org.example.model.Corretora;
import org.example.model.Usuario;
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
                Usuario usuario = AcessarConta.executar();
                // verifica se é corretora ou cliente
                if (Objects.isNull(usuario)){
                    System.err.println("Usuario não encontrado!");
                }else if(usuario instanceof Corretora){
                    menuCorretora();
                }else{
                    menuCliente();
                }

                break;
            case "2":

                System.out.println("Criar conta");
                break;
            case "3":
                System.out.println("simulação");
                Scanner ler = new Scanner(System.in);
                //Taxa de juros anual sera pega de acordo com o produto, sem o input do usuario
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
        System.out.println("Digite:\n0 - Sair da conta\n1 - Cadastrar/Atualizar produto");
        System.out.println("2 - Obter Relatório\n3 - Obter arrecadação");
        opcao = sc.nextLine();

        switch (opcao) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.println("Cadastrar/Atualizar produto");
                //new Corretora();
                break;
            case "2":
                System.out.println("Obter relatorio");
                break;
            case "3":
                System.out.println("Obter arrecadação");
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        menuCorretora();
    }
}
