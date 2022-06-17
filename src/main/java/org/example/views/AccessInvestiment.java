package org.example.views;

import org.example.model.Client;
import org.example.repository.RepositoryInvestiment;
import org.example.simulation.Simulation;

import java.util.Scanner;

public class AccessInvestiment {

    public static int printRegaste(Client client, Scanner sc) {
        System.out.println("Selecione o produto: ");
        new Simulation().runInvestiment(RepositoryInvestiment.getInvestimentList(client.getIdentificador()));
        System.out.print("Item: ");
        return sc.nextInt()-1;
    }

}
