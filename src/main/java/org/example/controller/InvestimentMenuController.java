package org.example.controller;

import org.example.model.Client;
import org.example.model.Investiment;
import org.example.repository.RepositoryInvestiment;
import org.example.simulation.Simulation;
import org.example.views.AccessInvestiment;
import org.example.views.creation.CreateInvestiment;
import org.example.views.menus.InvestimentMenu;

import java.util.Scanner;

public class InvestimentMenuController {
    public static void runInvestimentMenu(Scanner sc, Client client) {
        String option = new InvestimentMenu().printMenu(sc);

        switch (option) {
            case "0":
                InvestimentMenu.exit();
                return;
            case "1":
                RepositoryInvestiment.save(client,CreateInvestiment.printInvestiment(sc));
                break;
            case "2":
                new Simulation().runInvestiment(RepositoryInvestiment.getInvestimentList(client.getIdentificador()));
                break;
            case "3":
                int index = AccessInvestiment.printRegaste(client,sc);
                Investiment investiment = RepositoryInvestiment.getInvestimentList(client.getIdentificador()).get(index);
                client.deposit(investiment.getGanhoLiquido());
                RepositoryInvestiment.remove(client,index);
                break;
            default:
                InvestimentMenu.invalidOption();
        }
//        sc.nextLine();
        runInvestimentMenu(sc, client);
    }
}
