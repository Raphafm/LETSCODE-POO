package org.example.controller;
import org.example.model.Client;
import org.example.model.Stockbroker;
import org.example.model.User;
import org.example.views.*;
import java.util.Objects;
import java.util.Scanner;

public class MainMenuController {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        String option = new MainMenu().printMenu(sc);

        switch (option) {
            case "0":
                new MainMenu().exit();
                return;
            case "1":
                User usuario = AccessAccount.run(sc);
                if (Objects.isNull(usuario)) {
                    System.err.println("Usuario não encontrado!");
                } else if (usuario instanceof Stockbroker) {
                    StockbrokerMenuController.runStockbrokerMenu(sc, ((Stockbroker) usuario));
                } else {
                    ClientMenuController.runClientMenu(sc, ((Client) usuario));
                }
                break;
            case "2":
                CreateAccount.run(sc);
                break;
            case "3":
                System.out.println("simulação em construção");
                //Simulation meuInvestimento = new Simulation(RepositoryProducts.getInvestimento().getRentabilidadeAnual().doubleValue());
                //meuInvestimento.relatorio();
                break;
            default:
                MainMenu.invalidOption();
                break;
        }
        MainMenuController.run();
    }
}
