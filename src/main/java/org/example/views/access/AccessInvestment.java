package org.example.views.access;

import org.example.controller.service.ToInvest;
import org.example.controller.validations.ValidateWithMaxAndMin;
import org.example.model.Client;
import org.example.repository.RepositoryInvestment;
import java.math.BigDecimal;
import java.util.Scanner;

public class AccessInvestment {

    public static int printRedeem(Client client, Scanner sc) {
        System.out.println("Selecione o produto: ");
        ToInvest.run(RepositoryInvestment.getInvestmentList(client.getId()));
        System.out.print("Item: ");
        int index = ValidateWithMaxAndMin.run(sc, BigDecimal.valueOf(1),
                BigDecimal.valueOf(RepositoryInvestment.getAllInvestments().size())).intValue()-1;
        sc.nextLine();
        return index;
    }
}
