package org.example.views.creation;

import org.example.controller.validations.ValidateNumber;
import org.example.controller.validations.ValidateWithMaxAndMin;
import org.example.model.Client;
import org.example.model.Investment;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;
import org.example.views.show.ShowProducts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateInvestiment {
    public static Investment printInvestment(Scanner sc, Client client) {
        int option;
        do {
            System.out.println("Selecione o produto: ");
            ShowProducts.showProducts(RepositoryProducts.getProducts());
            System.out.print("Item: ");
            option = ValidateNumber.run(sc).intValue();
            if(!RepositoryProducts.getKeyProducts().containsKey(option)){
                System.out.println("Codido do produto invalido!\nTente novamente!");//colocar de cor red
            }
        } while (!RepositoryProducts.getKeyProducts().containsKey(option));

        System.out.print("Insira a quantia que você deseja investir: ");

        //travamento no investimento
        BigDecimal quantiaInvestida = ValidateWithMaxAndMin.run(sc,
                RepositoryProducts.getKeyProducts().get(option).getMinInvestment(), client.getFund());

        Products productSelected = RepositoryProducts.getKeyProducts().get(option);
        Investment investment = new Investment(productSelected, LocalDate.now(), quantiaInvestida);
        sc.nextLine();

        return investment;
    }
}
