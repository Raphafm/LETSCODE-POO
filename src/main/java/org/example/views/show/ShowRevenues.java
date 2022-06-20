package org.example.views.show;

import org.example.model.Client;
import org.example.model.TextColors;
import org.example.model.Investment;
import org.example.repository.RepositoryInvestment;
import org.example.repository.RepositoryUsers;

import java.math.BigDecimal;
import java.util.Map;

    public class ShowRevenues {
        public static <K,V> void run(Map<K,V> listAllInvestment){
            System.out.println();
            BigDecimal revenueTotal = BigDecimal.ZERO;
            for (K key : listAllInvestment.keySet()) {
                BigDecimal revenue = BigDecimal.ZERO;
                for (Client client : RepositoryUsers.getClientList()) {
                    if(client.getId().equals(key.toString())){
                        System.out.print(TextColors.YELLOW);
                        System.out.println(client.getName());
                        System.out.print(TextColors.RESET);
                        break;
                    }
                }
                for (Investment investment : RepositoryInvestment.getInvestmentList(key.toString())) {
                    revenue = revenue.add(investment.getProfitStockbroker());
                }
                System.out.printf("\tArrecadação: R$ %.2f%n",revenue);
                revenueTotal = revenueTotal.add(revenue);
            }
            System.out.print(TextColors.GREEN);
            System.out.printf("%nArrecadação Total: R$ %.2f%n",revenueTotal);
            System.out.print(TextColors.RESET);
        }
    }

