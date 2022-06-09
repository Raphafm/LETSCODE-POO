package org.example.views;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;
import org.example.model.Stockbroker;
import org.example.repository.RepositoryUsers;

import java.util.*;

public class StockbrokerMenu {
    public static void stockbrokerMenu(Scanner sc, Stockbroker corretora) {
        System.out.println("Bem vindo ao menu da corretora");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Cadastrar/Atualizar produto");
        System.out.println("2 - Obter Relatório\n3 - Obter arrecadação\n4 - Visualizar produtos por vencimento");
        System.out.println("5 - Visualizar clientes");
        System.out.println("6 - Visualizar produtos por ordem alfabética");
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
                System.out.println();
                List<Products> produtosPorVencimento = Products.ordenarPorVencimento();
//                List<Products> produtosPorVencimento = RepositoryProducts.getProducts();
//                Collections.sort(produtosPorVencimento);
                produtosPorVencimento.forEach(products -> System.out.print(products));
                System.out.println();
                break;
            case "5":
                System.out.println();
                RepositoryUsers.getContasLista().forEach(user -> System.out.print(user));
                System.out.println();
                break;
            case "6":
                System.out.println();
                List<Products> produtosPorAlfabeto = Products.ordemAlfabetica();
                produtosPorAlfabeto.forEach(products -> System.out.print(products));
                System.out.println();
                break;
            default:
                System.out.println("Opção inválida, digite novamente.");
                break;
        }
        stockbrokerMenu(sc, corretora);
    }
}
