package org.example.views.creation;

import org.example.model.Investiment;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;
import org.example.views.ShowProducts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateInvestiment {
    public static Investiment printInvestiment(Scanner sc) {

        System.out.println("Selecione o produto: ");
        ShowProducts.showProducts(RepositoryProducts.getProducts());
        System.out.print("Item: ");
        int option = sc.nextInt();

        System.out.print("Insira a quantia que você deseja investir: ");
        BigDecimal quantiaInvestida = sc.nextBigDecimal();

        Products productSelected = RepositoryProducts.getKeyProducts().get(option);
        Investiment investiment = new Investiment(productSelected, LocalDate.now(), quantiaInvestida);

        return investiment;
    }

}
