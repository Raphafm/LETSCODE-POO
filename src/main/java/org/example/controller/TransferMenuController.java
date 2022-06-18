package org.example.controller;
import org.example.model.Client;
import org.example.views.access.AccessTransfer;
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
                Withdraw.run(AccessTransfer.run(sc),client);
                break;
            case "2":
                Deposit.run(AccessTransfer.run(sc),client);
                break;
            default:
                TransferMenu.invalidOption();
        }
        runTransferMenu(sc, client);
    }
}
