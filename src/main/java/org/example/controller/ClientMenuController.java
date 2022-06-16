package org.example.controller;
import org.example.model.Client;
import org.example.views.ShowAccount;
import org.example.views.menus.ClientMenu;

import java.util.Scanner;

public class ClientMenuController{
    public static void runClientMenu(Scanner sc, Client cliente) {
        String option = ClientMenu.printMenu(sc);

        switch (option) {
            case "0":
                ClientMenu.exit();
                return;
            case "1":
                ShowAccount.run(cliente);
                break;
            case "2":
                System.out.print(cliente.printExtract());
                break;
            case "3":
                TransferMenuController.runTransferMenu(sc, cliente);
                break;
            case "4":
                System.out.println("investir em construção");
                break;
            default:
                ClientMenu.invalidOption();
                break;
        }
        runClientMenu(sc, cliente);
    }

}
