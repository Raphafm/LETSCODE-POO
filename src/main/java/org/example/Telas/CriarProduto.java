package org.example.Telas;

import org.example.model.Produtos;

import java.math.BigDecimal;
import java.util.Scanner;

public class  CriarProduto {
    public Produtos informarProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, insira os dados.");
        System.out.println("Codigo: ");
        int code = sc.nextInt();
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Rentabilidade Anual: ");
        BigDecimal rentabilidadeAnual = sc.nextBigDecimal();
        System.out.println("Investimento minimo: ");
        BigDecimal investimentoMinimo = sc.nextBigDecimal();
        System.out.println("Preço unitário: ");
        BigDecimal precoUnitario = sc.nextBigDecimal();
        System.out.println("Vencimento: ");
        String vencimento = sc.nextLine();

        return new Produtos(code,nome,rentabilidadeAnual,investimentoMinimo,precoUnitario,vencimento);
    }

}
