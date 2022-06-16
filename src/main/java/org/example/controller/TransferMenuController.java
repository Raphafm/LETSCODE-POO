package org.example.controller;
import org.example.model.Client;
import org.example.views.AccessTransfer;
import org.example.views.menus.TransferMenu;
import java.util.Scanner;

public class TransferMenuController {
    public static void runTransferMenu(Scanner sc, Client client){
        String option = new TransferMenu().printMenu(sc);

        switch (option) {
            case "0":
                TransferMenu.exit();
                return;
            case "1":
                client.withdraw(AccessTransfer.run(sc));
                break;
            case "2":
                client.deposit(AccessTransfer.run(sc));
                break;
            default:
                TransferMenu.invalidOption();
        }
        runTransferMenu(sc, client);
    }
}
