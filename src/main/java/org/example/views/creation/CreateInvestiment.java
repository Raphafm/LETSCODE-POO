package org.example.views.creation;

import org.example.controller.ClientMenuController;
import org.example.controller.Withdraw;
import org.example.controller.validations.ValidateNumber;
import org.example.model.Client;
import org.example.model.Cores;
import org.example.model.Investment;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;
import org.example.views.menus.InvestimentMenu;
import org.example.views.show.ShowProducts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;
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
                System.out.println(Cores.RED);
                System.out.println("Codido do produto invalido!\nTente novamente!");
                System.out.println(Cores.RESET);
            }
        } while (!RepositoryProducts.getKeyProducts().containsKey(option));

        System.out.print("Insira a quantia que você deseja investir: ");

        BigDecimal valueInvested = validateValueInvested(sc,
                RepositoryProducts.getKeyProducts().get(option).getMinInvestment(), client.getFund(), client);

        Products productSelected = RepositoryProducts.getKeyProducts().get(option);
        Investment investment = new Investment(productSelected, LocalDate.now(), valueInvested);
        sc.nextLine();
        Withdraw.run(valueInvested, client);

        return investment;
    }

    private static BigDecimal validateValueInvested(Scanner sc, BigDecimal min, BigDecimal max, Client client) {
        try {
            BigDecimal valor = sc.nextBigDecimal();
            if (max.compareTo(min) < 0) {
                System.out.println(Cores.RED);
                System.out.println("Saldo insuficiente para fazer investimento minimo");
                System.out.println("Deposite mais dinheiro em sua conta para realizar esta operação");
                System.out.println(Cores.RESET);
                InvestimentMenu.exit();
                ClientMenuController.runClientMenu(sc, client);
            }
            if (valor.compareTo(min) >= 0 && valor.compareTo(max) <= 0) {
                return  valor;
            }
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.printf("Valor invalido, digite valores entre %s e %s%n", min, max);
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return validateValueInvested(sc, min, max, client);

        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.println("Não digite letras, por favor");
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return validateValueInvested(sc, min, max, client);
        }
    }
}
