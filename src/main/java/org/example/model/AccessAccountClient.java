package org.example.model;
import org.example.controller.ClientMenuController;
import java.util.Scanner;

public class AccessAccountClient extends User{
    public AccessAccountClient(String nome, String login, String password, String id) {
        super(nome, login, password, id);
    }

    public static void access(Client client, Scanner sc){
        ClientMenuController.runClientMenu(sc, client);
    }
}
