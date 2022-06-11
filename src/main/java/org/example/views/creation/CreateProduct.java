package org.example.views.creation;
import org.example.model.Products;
import org.example.model.ProductsType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateProduct {
    public Products run(Scanner sc){
        // TODO tratar exceções
        System.out.println("Atualizando ou Cadastrando produtos");
        System.out.println("Por favor, insira os dados.");
        System.out.print("Codigo: ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Rentabilidade Anual: ");
        double annualProfitability = sc.nextDouble();
        System.out.print("Investimento minimo: ");
        BigDecimal investimentoMinimo = sc.nextBigDecimal();
        System.out.print("Preço unitário: ");
        BigDecimal precoUnitario = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Vencimento: ");
        System.out.print("\tDia: ");
        int dia = sc.nextInt();
        System.out.print("\tMês: ");
        int mes = sc.nextInt();
        System.out.print("\tAno: ");
        int ano = sc.nextInt();
        LocalDate vencimento = LocalDate.of(ano,mes,dia);

        // TODO
        //dia 1 a 30
        //mes 1 a 12
        //ano maior atual
        System.out.print("Porcentagem de risco do investimento: ");
        int porcentagemRiscoDoInvestimento = sc.nextInt();
        System.out.println("Selecione o tipo do produto: ");
        for (int i=0; i < ProductsType.values().length; i++){
            System.out.printf("\t %d - %s %n",i,ProductsType.values()[i].getLabel());
        }
        System.out.print("Resposta: ");
        int tipoProduto = sc.nextInt();

        return new Products(code, name, annualProfitability,investimentoMinimo,precoUnitario,vencimento,porcentagemRiscoDoInvestimento,ProductsType.values()[tipoProduto]);
    }

    public static double validateAnnualProfitability(Scanner sc) {
      return 0;
    }
}