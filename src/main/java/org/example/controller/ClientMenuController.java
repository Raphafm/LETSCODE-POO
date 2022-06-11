package org.example.controller;
import org.example.model.Client;
import org.example.views.AcessTransfer;
import org.example.views.ClientMenu;
import org.example.views.TransferMenu;
import java.util.Scanner;

public class ClientMenuController{
    public static void runClientMenu(Scanner sc, Client cliente) {
        String option = new ClientMenu().printMenu(sc);

        switch (option) {
            case "0":
                ClientMenu.exit();
                return;
            case "1":
                System.out.print(cliente.printExtract());
                break;
            case "2":
                TransferMenuController.runTransferMenu(sc, cliente);
                break;
            case "3":
                System.out.println("investir em construção");
                break;
            default:
                ClientMenu.invalidOption();
                break;
        }
        runClientMenu(sc, cliente);
    }

}
