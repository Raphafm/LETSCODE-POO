package org.example.Menus;

import java.util.Objects;
import java.util.Scanner;

import org.example.Telas.AcessarConta;
import org.example.Telas.CriarConta;
import org.example.model.Corretora;
import org.example.model.Usuario;
import org.example.simulacao.Simulacao;

public class Menus {
    private static final Scanner sc = new Scanner(System.in);
    private static String opcao;

    public static void menuPrincipal() {

        System.out.println("Bem vindo ao menu principal");
        System.out.println("Digite:\n0 - Sair\n1 - Fazer o login\n2 - Criar conta\n3 - Fazer simulação");
        System.out.print("Opcao: ");
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
                    menuCorretora(usuario);
                }else{
                    menuCliente();
                }

                break;
            case "2":
                new CriarConta().excecutar();
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
        System.out.print("Opcao: ");
        opcao = sc.nextLine();

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
        menuCliente();
    }

    public static void menuCorretora(Usuario usuario) {
        System.out.println("Bem vindo ao menu da corretora");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Cadastrar/Atualizar produto");
        System.out.println("2 - Obter Relatório\n3 - Obter arrecadação");
        System.out.print("Opcao: ");
        opcao = sc.nextLine();
        Corretora corretora = new Corretora(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getIdentificador());

        switch (opcao) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.println("Cadastrar/Atualizar produto");
                corretora.cadastrarAtualizar();
                break;
            case "2":
                System.out.println("Obter relatorio em construção");
                break;
            case "3":
                System.out.println("Obter arrecadação em construção");
                break;
            default:
                System.out.println("Opção inválida, digite novamente.");
                break;
        }
        menuCorretora(usuario);
    }
}
