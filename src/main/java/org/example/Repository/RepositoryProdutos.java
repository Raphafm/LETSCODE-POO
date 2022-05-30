package org.example.Repository;
import org.example.model.Produtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class RepositoryProdutos {
    private static ArrayList<Produtos> titulos;
    static Scanner ler = new Scanner(System.in);
    public static void inicializar(){
        titulos = new ArrayList<>();
        Produtos produto1 = new Produtos(1,"Tesouro Prefixado", BigDecimal.valueOf(12.38d),BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), "01/01/2025");
        titulos.add(produto1);
    }

    public static ArrayList<Produtos> getTitulos() {
        return titulos;
    }
    //printa todos investimentos do repositório e suas caracteristicas e depois disso pede ao usuário para escolher um
    public static Produtos getInvestimento() {
        ArrayList<Produtos> listaDeInvestimentos =getTitulos();
        int i =0;
        for (Produtos investimento : listaDeInvestimentos) {
            i+=1;
            System.out.printf("%d - Nome: %s -- Investimento Mínimo: %.2f R$ -- Preço unitário: %.2f R$ -- " +
                            "Rentabilidade anual: %.2f -- Vencimento: %s\n",i, investimento.getNome(),
                    investimento.getInvestimentoMinimo(), investimento.getPrecoUnitario(),
                    investimento.getRentabilidadeAnual().multiply(BigDecimal.valueOf(100d)),
                    investimento.getVencimento());
        }
        System.out.print("Escolha uma opção: ");
        int escolha = ler.nextInt();
        return listaDeInvestimentos.get(escolha-1);
    }
}
