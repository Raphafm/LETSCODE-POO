package org.example.views.show;
import org.example.controller.service.ToInvest;
import org.example.model.Client;
import org.example.model.TextColors;
import org.example.repository.RepositoryInvestment;
import org.example.repository.RepositoryUsers;

import java.util.Map;

public class ShowAllInvestment {
    public static <K,V> void run(Map<K,V> listAllInvestment){
        System.out.println();
        for (K key : listAllInvestment.keySet()) {
            for (Client client : RepositoryUsers.getClientList()) {
                if(client.getId().equals(key.toString())){
                    System.out.print(TextColors.YELLOW);
                    System.out.println(client.getName());
                    System.out.print(TextColors.RESET);
                    break;
                }
            }
            ToInvest.run(RepositoryInvestment.getInvestmentList(key.toString()));
        }
        System.out.println();
    }
    public static void warning(){
        System.out.print(TextColors.RED);
        System.out.println("Não existe nenhum investimento");
        System.out.print(TextColors.RESET);
    }
}

