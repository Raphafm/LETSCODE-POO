package org.example.controller;
import org.example.model.Products;
import org.example.model.Stockbroker;
import org.example.repository.RepositoryUsers;
import org.example.views.StockbrokerMenu;
import java.util.List;
import java.util.Scanner;

public class StockbrokerMenuController {
    public static void runStockbrokerMenu(Scanner sc, Stockbroker stockbroker) {
        String option = new StockbrokerMenu().printMenu(sc);

        switch (option) {
            case "0":
                new StockbrokerMenu().exit();
                return;
            case "1":
                stockbroker.registerUpdate(sc);
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
                StockbrokerMenu.invalidOption();
                break;
        }
        runStockbrokerMenu(sc, stockbroker);
    }

}
