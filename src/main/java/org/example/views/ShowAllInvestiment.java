package org.example.views;

import org.example.model.Client;
import org.example.repository.RepositoryInvestiment;
import org.example.repository.RepositoryUsers;
import org.example.simulation.Simulation;

import java.util.Map;

public class ShowAllInvestiment {
    public static <K,V> void run(Map<K,V> listAllInvestiment){
        System.out.println();
        for (K key : listAllInvestiment.keySet()) {
            for (Client cliente : RepositoryUsers.getListaClientes()) {
                if(cliente.getIdentificador().equals(key.toString())){
                    System.out.println(cliente.getNome());
                    break;
                }
            }
            new Simulation().runInvestiment(RepositoryInvestiment.getInvestimentList(key.toString()));
        }
        System.out.println();
    }
}
