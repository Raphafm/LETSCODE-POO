package org.example.menus;
import org.example.Repository.RepositoryProducts;
import org.example.Model.Stockbroker;
import java.util.Scanner;

public class StockbrokerMenu {
    public static void stockbrokerMenu(Scanner sc, Stockbroker corretora) {
        System.out.println("Bem vindo ao menu da corretora");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Cadastrar/Atualizar produto");
        System.out.println("2 - Obter Relatório\n3 - Obter arrecadação\n4 - Visualizar produtos");
        System.out.print("Opcao: ");
        String option = sc.nextLine();

        switch (option) {
            case "0":
                System.out.println("Saindo da Conta e voltando para o menu principal");
                return;
            case "1":
                System.out.println("Cadastrar/Atualizar produto");
                corretora.registerUpdate(sc);
                break;
            case "2":
                System.out.println("Obter relatorio em construção");
                break;
            case "3":
                System.out.println("Obter arrecadação em construção");
                break;
            case "4":
                RepositoryProducts.getListaDeInvestimento();
                break;
            default:
                System.out.println("Opção inválida, digite novamente.");
                break;
        }
        stockbrokerMenu(sc, corretora);
    }
}
