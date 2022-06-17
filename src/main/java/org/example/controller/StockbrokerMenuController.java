package org.example.controller;

import org.example.model.Investiment;
import org.example.model.Products;
import org.example.model.Stockbroker;
import org.example.repository.RepositoryInvestiment;
import org.example.repository.RepositoryUsers;
import org.example.views.ShowAllInvestiment;
import org.example.views.ShowProducts;
import org.example.views.ShowRevenues;
import org.example.views.menus.StockbrokerMenu;

import java.math.BigDecimal;
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
                ShowAllInvestiment.run(RepositoryInvestiment.getInvestimentsMap());
                break;
            case "3":
                ShowRevenues.run(RepositoryInvestiment.getInvestimentsMap());
                break;
            case "4":
                System.out.println();
                RepositoryUsers.getListaClientes().forEach(System.out::println);
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
