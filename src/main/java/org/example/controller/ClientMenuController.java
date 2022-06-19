package org.example.controller;
import org.example.model.Client;
import org.example.views.show.ShowAccount;
import org.example.views.menus.ClientMenu;
import java.util.Scanner;

public class ClientMenuController{
    public static void runClientMenu(Scanner sc, Client client) {
        String option = new ClientMenu().printMenu(sc);

        switch (option) {
            case "0":
                ClientMenu.exit();
                return;
            case "1":
                ShowAccount.run(client);
                break;
            case "2":
                System.out.print(client.toStringExtract());
                break;
            case "3":
                TransferMenuController.runTransferMenu(sc, client);
                break;
            case "4":
                InvestmentMenuController.runInvestmentMenu(sc, client);
                break;
            default:
                ClientMenu.invalidOption();
                break;
        }
        runClientMenu(sc, client);
    }

}
