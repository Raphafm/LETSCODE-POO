package org.example.controller;
import org.example.model.Client;
import org.example.model.Stockbroker;
import org.example.model.User;
import org.example.simulation.Simulation;
import org.example.views.*;
import org.example.views.creation.CreateAccount;
import org.example.views.menus.MainMenu;
import java.util.Objects;
import java.util.Scanner;


public class MainMenuController {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
//        System.out.println();
        String option = new MainMenu().printMenu(sc);

        switch (option) {
            case "0":
                MainMenu.exit();
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
//                System.out.println("simulação em construção");
//                Simulation meuInvestimento = new Simulation(RepositoryProducts.getInvestimento().getRentabilidadeAnual().doubleValue());
//                meuInvestimento.relatorio();
                new Simulation().runSimulation(sc);
                break;
            default:
                MainMenu.invalidOption();
                break;
        }
        sc.nextLine(); // limpar o scanner
        MainMenuController.run();
    }
}
