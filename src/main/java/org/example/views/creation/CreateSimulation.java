package org.example.views.creation;
import org.example.controller.validations.ValidateNumber;
import org.example.controller.validations.ValidateWithMaxAndMin;
import org.example.model.Cores;
import org.example.model.Investment;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;
import org.example.views.show.ShowProducts;
import java.math.BigDecimal;
import java.util.Scanner;

public class CreateSimulation {
    public static Investment printSimulation(Scanner sc) {

        int code;
        do {
            System.out.println("Selecione o produto: ");
            ShowProducts.showProducts(RepositoryProducts.getProducts());
            System.out.print("Codigo: ");
            code = ValidateNumber.run(sc).intValue();
            if(!RepositoryProducts.getKeyProducts().containsKey(code)){
                System.out.println(Cores.RED);
                System.out.println("Codido do produto invalido!\nTente novamente!");
                System.out.println(Cores.RESET);
            }
        } while (!RepositoryProducts.getKeyProducts().containsKey(code));

        System.out.print("Insira a quantia que você deseja investir: ");
        BigDecimal quantiaInvestida = ValidateWithMaxAndMin.run(sc,
                RepositoryProducts.getKeyProducts().get(code).getMinInvestment(), BigDecimal.valueOf(1000000000));

        System.out.print("Insira o tempo que você quer manter esse investimento (insira o tempo em dias): ");
        int tempoDiasInvestido = ValidateNumber.run(sc).intValue();

        Products productSelected = RepositoryProducts.getKeyProducts().get(code);

        return new Investment(productSelected, tempoDiasInvestido, quantiaInvestida);
    }
}
