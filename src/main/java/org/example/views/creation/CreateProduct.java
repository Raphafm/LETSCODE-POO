package org.example.views.creation;
import org.example.controller.validations.ValidateNumber;
import org.example.controller.validations.ValidateWithMaxAndMin;
import org.example.model.Products;
import org.example.model.ProductsType;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Scanner;

public class CreateProduct {
    public Products run(Scanner sc) {

        System.out.println("Atualizando ou Cadastrando produtos");
        System.out.println("Por favor, insira os dados.");

        System.out.print("Codigo: ");
        int code = ValidateNumber.run(sc).intValue();
        sc.nextLine();

        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Rentabilidade Anual: ");

        double annualProfitability = ValidateNumber.run(sc).doubleValue();

        System.out.print("Investimento minimo: ");
        BigDecimal minInvestment = ValidateNumber.run(sc);

        System.out.print("Preço unitário: ");
        BigDecimal unitPrice = ValidateNumber.run(sc);

        System.out.println("Vencimento: ");
        System.out.print("\tDia: ");
        int day = ValidateWithMaxAndMin.run(sc, BigDecimal.valueOf(1),BigDecimal.valueOf(30)).intValue();
        System.out.print("\tMês: ");
        int month = ValidateWithMaxAndMin.run(sc, BigDecimal.valueOf(1),BigDecimal.valueOf(12)).intValue();
        System.out.print("\tAno: ");
        int year = ValidateWithMaxAndMin.run(sc, BigDecimal.valueOf(LocalDate.now().getYear()),BigDecimal.valueOf(LocalDate.now().getYear() + 35)).intValue();
        LocalDate dueDate = LocalDate.of(year, month, day);
        LocalDate.now();

        System.out.println("Selecione o tipo do produto: ");
        for (int i = 0; i < ProductsType.values().length; i++) {
            System.out.printf("\t %d - %s %n", i, ProductsType.values()[i].getLabel());
        }
        System.out.print("Resposta: ");
        int productType = ValidateWithMaxAndMin.run(sc, BigDecimal.valueOf(0),BigDecimal.valueOf(ProductsType.values().length)).intValue();
        sc.nextLine();

        return new Products(code, name, annualProfitability, minInvestment,
                dueDate, ProductsType.values()[productType]);
    }
}