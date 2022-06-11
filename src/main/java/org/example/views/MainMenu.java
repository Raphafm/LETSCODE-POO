package org.example.views;
import java.util.Objects;
import java.util.Scanner;
import org.example.model.Client;
import org.example.views.AccessAccount;
import org.example.views.ClientMenu;
import org.example.views.CreateAccount;
import org.example.model.Stockbroker;
import org.example.model.User;
import org.example.views.StockbrokerMenu;

public class MainMenu extends BasicMenu{
    public String printMenu(Scanner sc) {


        System.out.println("Bem vindo ao menu principal");
        System.out.println("Digite:\n0 - Sair\n1 - Fazer o login\n2 - Criar conta\n3 - Fazer simulação");
        System.out.print("Opcao: ");
        String option = sc.nextLine();
        return option;
    }

}
