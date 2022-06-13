package org.example.views.creation;
import org.example.model.Investiment;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;
import org.example.views.ShowProducts;
import java.math.BigDecimal;
import java.util.Scanner;

public class CreateSimulation {
    public static Investiment printSimulation(Scanner sc) {

        System.out.println("Selecione o produto: ");
        ShowProducts.showProducts(RepositoryProducts.getProducts());
        System.out.print("Item: ");
        int option = sc.nextInt();

        System.out.print("Insira a quantia que você deseja investir: ");
        BigDecimal quantiaInvestida = sc.nextBigDecimal();

        System.out.print("Insira o tempo que você quer manter esse investimento (insira o tempo em dias): ");
        int tempoDiasInvestido = sc.nextInt();

        Products productSelected = RepositoryProducts.getKeyProducts().get(option);
        Investiment investiment = new Investiment(productSelected, tempoDiasInvestido, quantiaInvestida);

        return investiment;
    }

}
