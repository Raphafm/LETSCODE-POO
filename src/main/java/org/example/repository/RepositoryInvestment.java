package org.example.repository;
import org.example.model.Client;
import org.example.model.Investment;
import org.example.controller.service.Calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class RepositoryInvestment {

    private static Map<String, List<Investment>> keyInvestments;

    public static void initialize() {
        keyInvestments = new TreeMap<>();
        List<Investment> investmentsList = new ArrayList<>();
        Investment clientInvestment1 = new Investment(RepositoryProducts.getKeyProducts().get(1), LocalDate.of(2021,1,1), BigDecimal.valueOf(1000));
        investmentsList.add(clientInvestment1);

        keyInvestments.put("12345678901", investmentsList);
        Calculator.run(clientInvestment1);

    }

    public static void save(Client client, Investment investment) {
        List<Investment> investmentsList = Objects.isNull(getInvestmentList(client.getId())) ?
                new ArrayList<>() : getInvestmentList(client.getId());
        investmentsList.add(investment);
        keyInvestments.put(client.getId(), investmentsList);
        Calculator.run(investment);
    }

    public static List<Investment> getInvestmentList(String key) {
        return keyInvestments.get(key);
    }

    public static List<Investment> getAllInvestments() {
        List<Investment> investmentsList = new ArrayList<>();
        for (String key : keyInvestments.keySet()) {
            if(Objects.nonNull(getInvestmentList(key))){
                investmentsList.addAll(getInvestmentList(key));
            }
        }
        return investmentsList;
    }

    public static Map<String, List<Investment>> getInvestmentsMap() {
        return keyInvestments;
    }

    public static void remove(Client client, int index) {
        List<Investment> investmentsList = getInvestmentList(client.getId());
        investmentsList.remove(index);
        keyInvestments.put(client.getId(), investmentsList);
    }

}