package org.example.views.creation;
import org.example.controller.validations.ValidateNumber;
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
        System.out.print("Codigo: ");

        int code = ValidateNumber.run(sc).intValue();
        sc.nextLine();

        System.out.print("Insira a quantia que você deseja investir: ");
        BigDecimal quantiaInvestida = ValidateNumber.run(sc);

        System.out.print("Insira o tempo que você quer manter esse investimento (insira o tempo em dias): ");
        int tempoDiasInvestido = ValidateNumber.run(sc).intValue();

        Products productSelected = RepositoryProducts.getKeyProducts().get(code);

        return new Investiment(productSelected, tempoDiasInvestido, quantiaInvestida);
    }
}
