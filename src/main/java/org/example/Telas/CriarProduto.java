package org.example.Telas;

import org.example.Model.Produtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class  CriarProduto {
    public Produtos informarProduto(Scanner sc){
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

        return new Produtos(code,nome,rentabilidadeAnual,investimentoMinimo,precoUnitario,vencimento);
    }

}
