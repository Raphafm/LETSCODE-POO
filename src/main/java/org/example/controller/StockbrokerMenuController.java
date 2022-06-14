package org.example.controller;
import org.example.model.Products;
import org.example.model.Stockbroker;
import org.example.repository.RepositoryUsers;
import org.example.views.ShowProducts;
import org.example.views.menus.StockbrokerMenu;
import java.util.Scanner;

public class StockbrokerMenuController {
    public static void runStockbrokerMenu(Scanner sc, Stockbroker stockbroker) {
        String option = StockbrokerMenu.printMenu(sc);

        switch (option) {
            case "0":
                StockbrokerMenu.exit();
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
                RepositoryUsers.getContasLista().forEach(System.out::println);
                System.out.println();
                break;
            case "5":
                ShowProducts.showProducts(Products.ordenarPorVencimento());
                break;
            case "6":
                ShowProducts.showProducts(Products.ordemAlfabetica());
                break;
            default:
                StockbrokerMenu.invalidOption();
                break;
        }
        runStockbrokerMenu(sc, stockbroker);
    }

}
