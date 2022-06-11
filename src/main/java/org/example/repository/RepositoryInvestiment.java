package org.example.repository;
import org.example.model.Client;
import org.example.model.Investiment;
import java.math.BigDecimal;
import java.util.*;

public class RepositoryInvestiment {
    static Scanner sc = new Scanner(System.in);
    private static Map<String, List<Investiment>> keyInvestiments;

    public static void initialize(){
        keyInvestiments = new TreeMap<>();
        List<Investiment> investimentsList = new ArrayList<>();
        Investiment clientInvestiment1 = new Investiment(RepositoryProducts.getKeyProducts().get(1),100, BigDecimal.valueOf(1000));
        investimentsList.add(clientInvestiment1);
        keyInvestiments.put("12345678901",investimentsList);
    }

    public static void save(Client client,Investiment investiment) {
        List<Investiment> investimentsList = getInvestimentList(client.getIdentificador());
        investimentsList.add(investiment);
        keyInvestiments.put(client.getIdentificador(),investimentsList);
    }

    public static List<Investiment> getInvestimentList(String key){
        return keyInvestiments.get(key);
    }

    public static List<Investiment> getAllInvestiments() {
        List<Investiment> investimentsList= new ArrayList<>();
        for(String key : keyInvestiments.keySet()){
            investimentsList.addAll(getInvestimentList(key));
        }
        return investimentsList;
    }

    public static Map<String, List<Investiment>> getInvestimentsMap() {
        return keyInvestiments;
    }

}