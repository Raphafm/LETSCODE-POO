package org.example.controller.service;
import org.example.model.Investment;
import org.example.views.show.ShowYields;

import java.util.List;

public class ToInvest {
    public static void run(List<Investment> listInvestment) {
        for (int i = 0; i < listInvestment.size(); i++) {
            System.out.printf("%d - %s %s  %n",i+1, listInvestment.get(i).getDateInvested(),
                    listInvestment.get(i).getProduct().getName());
            Calculator.run(listInvestment.get(i));
            ShowYields.report(listInvestment.get(i), listInvestment.get(i).getYield(), listInvestment.get(i).getPriceIof(),
                    listInvestment.get(i).getProfitStockbroker(), listInvestment.get(i).getPriceIR(),
                    listInvestment.get(i).getPriceTotalYieldNet(), listInvestment.get(i).getPriceTotalYield());
        }
    }
}
