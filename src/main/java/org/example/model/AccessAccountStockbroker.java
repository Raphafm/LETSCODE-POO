package org.example.model;

import org.example.controller.StockbrokerMenuController;

import java.util.Scanner;

public class AccessAccountStockbroker extends User{
    public AccessAccountStockbroker(String nome, String login, String password, String id) {
        super(nome, login, password, id);
    }

    public static void access(Stockbroker stockbroker, Scanner sc){
        StockbrokerMenuController.runStockbrokerMenu(sc, stockbroker);
    }
}
