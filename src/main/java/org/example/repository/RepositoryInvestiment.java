package org.example.repository;

import org.example.model.Client;
import org.example.model.Investiment;
import org.example.simulation.Simulation;

import java.math.BigDecimal;
import java.util.*;

public class RepositoryInvestiment {
    static Scanner sc = new Scanner(System.in);
    private static Map<String, List<Investiment>> keyInvestiments;

    public static void initialize() {
        keyInvestiments = new TreeMap<>();
        List<Investiment> investimentsList = new ArrayList<>();
        Investiment clientInvestiment1 = new Investiment(RepositoryProducts.getKeyProducts().get(1), 20, BigDecimal.valueOf(1000));
        investimentsList.add(clientInvestiment1);
        keyInvestiments.put("12345678901", investimentsList);
        new Simulation().resumeCalculo(clientInvestiment1);

    }

    public static void save(Client client, Investiment investiment) {
        List<Investiment> investimentsList = Objects.isNull(getInvestimentList(client.getIdentificador())) ?
                new ArrayList<>() : getInvestimentList(client.getIdentificador());
        investimentsList.add(investiment);
        keyInvestiments.put(client.getIdentificador(), investimentsList);
        new Simulation().resumeCalculo(investiment);
    }

    public static List<Investiment> getInvestimentList(String key) {
        return keyInvestiments.get(key);
    }

    public static List<Investiment> getAllInvestiments() {
        List<Investiment> investimentsList = new ArrayList<>();
        for (String key : keyInvestiments.keySet()) {
            if(Objects.nonNull(getInvestimentList(key))){
                investimentsList.addAll(getInvestimentList(key));
            }
        }
        return investimentsList;
    }

    public static Map<String, List<Investiment>> getInvestimentsMap() {
        return keyInvestiments;
    }

    public static void remove(Client client, int index) {
        List<Investiment> investimentsList = getInvestimentList(client.getIdentificador());
        investimentsList.remove(index);
        keyInvestiments.put(client.getIdentificador(), investimentsList);
    }

}