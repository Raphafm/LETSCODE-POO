package org.example.Telas;

import org.example.model.Products;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProduct {
    public Products run(Scanner sc){
        System.out.println("Por favor, insira os dados.");
        System.out.print("Codigo: ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Rentabilidade Anual: ");
        BigDecimal rentabilidadeAnual = sc.nextBigDecimal();
        System.out.print("Investimento minimo: ");
        BigDecimal investimentoMinimo = sc.nextBigDecimal();
        System.out.print("Preço unitário: ");
        BigDecimal precoUnitario = sc.nextBigDecimal();
        sc.nextLine();
        System.out.print("Vencimento: ");
        String vencimento = sc.nextLine();
        //dia 1 a 30
        //mes 1 a 12
        //ano maior atual

        return new Products(code,nome,rentabilidadeAnual,investimentoMinimo,precoUnitario,vencimento);
    }

}
