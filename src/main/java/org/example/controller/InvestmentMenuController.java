package org.example.controller;

import org.example.controller.service.ToInvest;
import org.example.controller.validations.ValidateInvest;
import org.example.model.Client;
import org.example.model.Investment;
import org.example.repository.RepositoryInvestment;
import org.example.views.access.AccessInvestment;
import org.example.views.creation.CreateInvestiment;
import org.example.views.menus.InvestimentMenu;
import org.example.views.show.ShowAllInvestment;

import java.util.Objects;
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
                if (ValidateInvest.run(client)) {
                    ShowAllInvestment.warning();
                } else {
                    ToInvest.run(RepositoryInvestment.getInvestmentList(client.getId()));
                }
                break;
            case "3":
                if (ValidateInvest.run(client)) {
                    ShowAllInvestment.warning();
                } else {
                    int index = AccessInvestment.printRedeem(client, sc);
                    Investment investment = RepositoryInvestment.getInvestmentList(client.getId()).get(index);
                    Deposit.run(investment.getPriceTotalYieldNet(), client);
                    RepositoryInvestment.remove(client, index);
                }
                break;
            default:
                InvestimentMenu.invalidOption();
        }
        runInvestmentMenu(sc, client);
    }
}
