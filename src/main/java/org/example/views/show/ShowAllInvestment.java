package org.example.views.show;
import org.example.controller.service.ToInvest;
import org.example.model.Client;
import org.example.repository.RepositoryInvestment;
import org.example.repository.RepositoryUsers;

import java.util.Map;

public class ShowAllInvestment {
    public static <K,V> void run(Map<K,V> listAllInvestment){
        System.out.println();
        for (K key : listAllInvestment.keySet()) {
            for (Client client : RepositoryUsers.getClientList()) {
                if(client.getId().equals(key.toString())){
                    System.out.println(client.getName());
                    break;
                }
            }
            ToInvest.run(RepositoryInvestment.getInvestmentList(key.toString()));
        }
        System.out.println();
    }
}
