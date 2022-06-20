package org.example.controller;

import org.example.model.Products;
import org.example.model.Stockbroker;
import org.example.repository.RepositoryInvestment;
import org.example.views.show.ShowAllClients;
import org.example.views.show.ShowAllInvestment;
import org.example.views.show.ShowProducts;
import org.example.views.show.ShowRevenues;
import org.example.views.menus.StockbrokerMenu;

import java.util.Scanner;

public class StockbrokerMenuController {
    public static void runStockbrokerMenu(Scanner sc, Stockbroker stockbroker) {
        String option = new StockbrokerMenu().printMenu(sc);

        switch (option) {
            case "0":
                StockbrokerMenu.exit();
                return;
            case "1":
                stockbroker.registerUpdate(sc);
                break;
            case "2":
                ShowAllInvestment.run(RepositoryInvestment.getInvestmentsMap());
                break;
            case "3":
                ShowRevenues.run(RepositoryInvestment.getInvestmentsMap());
                break;
            case "4":
                ShowAllClients.run();
                break;
            case "5":
                ShowProducts.showProducts(Products.sortByDueDate());
                break;
            case "6":
                ShowProducts.showProducts(Products.sortByABC());
                break;
            default:
                StockbrokerMenu.invalidOption();
                break;
        }
        sc.reset();
        runStockbrokerMenu(sc, stockbroker);
    }

}
