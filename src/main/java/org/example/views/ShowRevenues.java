package org.example.views;

import org.example.model.Client;
import org.example.model.Investiment;
import org.example.repository.RepositoryInvestiment;
import org.example.repository.RepositoryUsers;
import org.example.simulation.Simulation;

import java.math.BigDecimal;
import java.util.Map;

    public class ShowRevenues {
        public static <K,V> void run(Map<K,V> listAllInvestiment){
            System.out.println();
            BigDecimal arrecadacaoTotal = BigDecimal.ZERO;
            for (K key : listAllInvestiment.keySet()) {
                BigDecimal arrecadacao = BigDecimal.ZERO;
                for (Client cliente : RepositoryUsers.getListaClientes()) {
                    if(cliente.getIdentificador().equals(key.toString())){
                        System.out.println(cliente.getNome());
                        break;
                    }
                }
                for (Investiment investiment : RepositoryInvestiment.getInvestimentList(key.toString())) {
                    arrecadacao = arrecadacao.add(investiment.getGanhoCoretora());
                }
                System.out.printf("\tArrecadação: R$ %.2f%n",arrecadacao);
                arrecadacaoTotal = arrecadacaoTotal.add(arrecadacao);
            }
            System.out.printf("%nArrecadação Total: R$ %.2f%n",arrecadacaoTotal);
        }
    }

