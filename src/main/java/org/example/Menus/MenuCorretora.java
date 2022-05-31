package org.example.Menus;

import org.example.Repository.RepositoryProdutos;
import org.example.model.Corretora;
import org.example.model.Usuario;
import java.util.Scanner;

public class MenuCorretora {
    public static void menuCorretora(Scanner sc, Usuario usuario) {
        System.out.println("Bem vindo ao menu da corretora");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Cadastrar/Atualizar produto");
        System.out.println("2 - Obter Relatório\n3 - Obter arrecadação\n4 - Visualizar produtos");
        System.out.print("Opcao: ");
        String opcao = sc.nextLine();
        Corretora corretora = new Corretora(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getIdentificador());

        switch (opcao) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.println("Cadastrar/Atualizar produto");
                corretora.cadastrarAtualizar(sc);
                break;
            case "2":
                System.out.println("Obter relatorio em construção");
                break;
            case "3":
                System.out.println("Obter arrecadação em construção");
                break;
            case "4":
                RepositoryProdutos.getListaDeInvestimento();
                break;
            default:
                System.out.println("Opção inválida, digite novamente.");
                break;
        }
        menuCorretora(sc, usuario);
    }
}
