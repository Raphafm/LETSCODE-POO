package org.example.controller.service;

import org.example.model.Investment;
import org.example.views.creation.CreateSimulation;
import org.example.views.show.ShowYields;

import java.util.Scanner;

public class Simulation {
    public static void run(Scanner sc) {
        Investment investment = CreateSimulation.printSimulation(sc);
        Calculator.run(investment);
        sc.nextLine();
        ShowYields.report(investment, investment.getYield(), investment.getPriceIof(), investment.getProfitStockbroker(),
                investment.getPriceIR(), investment.getPriceTotalYieldNet(), investment.getPriceTotalYield());
    }
}
