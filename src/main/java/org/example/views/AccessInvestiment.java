package org.example.views;

import org.example.controller.validations.ValidateWithMaxAndMin;
import org.example.model.Client;
import org.example.repository.RepositoryInvestiment;
import org.example.repository.RepositoryProducts;
import org.example.simulation.Simulation;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccessInvestiment {

    public static int printRegaste(Client client, Scanner sc) {
        System.out.println("Selecione o produto: ");
        new Simulation().runInvestiment(RepositoryInvestiment.getInvestimentList(client.getIdentificador()));
        System.out.print("Item: ");
        int index = ValidateWithMaxAndMin.run(sc, BigDecimal.valueOf(1),
                BigDecimal.valueOf(RepositoryProducts.getProducts().size())).intValue()-1;
        sc.nextLine();
        return index;
    }
}
