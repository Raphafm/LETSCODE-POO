package org.example.views.creation;

import org.example.model.Investment;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;
import org.example.views.show.ShowProducts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateInvestiment {
    public static Investment printInvestment(Scanner sc) {

        System.out.println("Selecione o produto: ");
        ShowProducts.showProducts(RepositoryProducts.getProducts());
        System.out.print("Item: ");//codigo do protudos
//        RepositoryProducts.getKeyProducts().containsKey(sc.nextInt());
        int option = sc.nextInt();



        System.out.print("Insira a quantia que você deseja investir: ");
        BigDecimal quantiaInvestida = sc.nextBigDecimal();

        Products productSelected = RepositoryProducts.getKeyProducts().get(option);
        Investment investment = new Investment(productSelected, LocalDate.now(), quantiaInvestida);
        sc.nextLine();

        return investment;
    }
}
