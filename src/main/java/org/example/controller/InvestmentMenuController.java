package org.example.controller;

import org.example.controller.service.ToInvest;
import org.example.model.Client;
import org.example.model.Investment;
import org.example.repository.RepositoryInvestment;
import org.example.views.access.AccessInvestment;
import org.example.views.creation.CreateInvestiment;
import org.example.views.menus.InvestimentMenu;

import java.util.Scanner;

public class InvestmentMenuController {
    public static void runInvestmentMenu(Scanner sc, Client client) {
        String option = new InvestimentMenu().printMenu(sc);

        switch (option) {
            case "0":
                InvestimentMenu.exit();
                return;
            case "1":
                RepositoryInvestment.save(client,CreateInvestiment.printInvestment(sc,client));
                break;
            case "2":
                ToInvest.run(RepositoryInvestment.getInvestmentList(client.getId()));
                break;
            case "3":
                int index = AccessInvestment.printRedeem(client,sc);
                Investment investment = RepositoryInvestment.getInvestmentList(client.getId()).get(index);
                Deposit.run(investment.getPriceTotalYieldNet(),client);
                RepositoryInvestment.remove(client,index);
                break;
            default:
                InvestimentMenu.invalidOption();
        }
        runInvestmentMenu(sc, client);
    }
}
