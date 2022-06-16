package org.example.views.creation;
import org.example.controller.validations.ValidateNumber;
import org.example.controller.validations.ValidateWithMaxAndMin;
import org.example.model.Cores;
import org.example.model.Products;
import org.example.model.ProductsType;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateProduct {
    public Products run(Scanner sc) {

        System.out.println("Atualizando ou Cadastrando produtos");
        System.out.println("Por favor, insira os dados.");

        System.out.print("Codigo: ");
        ValidateNumber<Integer> validatorInteger = new ValidateNumber<>();
        int code = validatorInteger.run(sc);
        sc.nextLine();

        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Rentabilidade Anual: ");
        ValidateNumber<Double> valdiatorDouble = new ValidateNumber<>();
        double annualProfitability = valdiatorDouble.run(sc);

        System.out.print("Investimento minimo: ");
        ValidateNumber<BigDecimal> validatorBigDecimal = new ValidateNumber<>();
        BigDecimal investimentoMinimo = validatorBigDecimal.run(sc);

        System.out.print("Preço unitário: ");
        BigDecimal precoUnitario = validatorBigDecimal.run(sc);

        System.out.println("Vencimento: ");
        System.out.print("\tDia: ");
        ValidateWithMaxAndMin<Integer> validateWithMaxAndMinInt = new ValidateWithMaxAndMin<>();
        int day = validateWithMaxAndMinInt.run(sc, 1, 30);
        System.out.print("\tMês: ");
        int month = validateWithMaxAndMinInt.run(sc, 1, 12);
        System.out.print("\tAno: ");
        int year = validateWithMaxAndMinInt.run(sc,LocalDate.now().getYear(), LocalDate.now().getYear() + 100);
        LocalDate vencimento = LocalDate.of(year, month, day);

        System.out.print("Porcentagem de risco do investimento: ");
        int porcentagemRiscoDoInvestimento = validatorInteger.run(sc).intValue();

        System.out.println("Selecione o tipo do produto: ");
        for (int i = 0; i < ProductsType.values().length; i++) {
            System.out.printf("\t %d - %s %n", i, ProductsType.values()[i].getLabel());
        }
        System.out.print("Resposta: ");
        int tipoProduto = validateWithMaxAndMinInt.run(sc, 0, ProductsType.values().length);
        sc.nextLine();

        return new Products(code, name, annualProfitability, investimentoMinimo, precoUnitario,
                vencimento, porcentagemRiscoDoInvestimento, ProductsType.values()[tipoProduto]);
    }

    /*
    private static int validateInt(Scanner sc) {
        try {
            return sc.nextInt();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.println("Não digite letras, por favor");
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return validateInt(sc);
        }
    }

    private static double validateDouble(Scanner sc) {
        try {
            return sc.nextDouble();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.println("Não digite letras, por favor");
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return validateDouble(sc);
        }
    }

    private static BigDecimal validateBigDecimal(Scanner sc) {
        try {
            return sc.nextBigDecimal();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.println("Não digite letras, por favor");
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return validateBigDecimal(sc);
        }
    }

    private static int validateWithMaxandMin(Scanner sc, int min, int max) {
        try {
            int date = sc.nextInt();
            if (date >= min && date <= max) {
                return date;
            } else {
                System.out.println(Cores.RED);
                System.out.printf("Valor invalido, digite valores entre %s e %s%n", min, max);
                System.out.println(Cores.RESET);
                System.out.print("Nova resposta: ");
                return validateWithMaxandMin(sc, min, max);
            }
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.println("Não digite letras, por favor");
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return validateWithMaxandMin(sc, min, max);
        }
    }

    private static int validateYear(Scanner sc) {
        try {
            int year = sc.nextInt();
            if (year > LocalDate.now().getYear()) {
                return year;
            } else {
                System.out.println(Cores.RED);
                System.out.printf("Valor invalido, digite um valor maior que %d", LocalDate.now().getYear());
                System.out.println(Cores.RESET);
                System.out.print("Nova resposta: ");
                return validateYear(sc);
            }
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.println("Não digite letras, por favor");
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return validateYear(sc);
        }
    }

     */
}