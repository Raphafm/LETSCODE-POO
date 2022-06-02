package org.example.Repository;
import java.math.BigDecimal;
import org.example.Model.Products;
import java.util.ArrayList;
import java.util.Scanner;

public class RepositoryProducts {
    private static ArrayList<Products> titulos;
    static Scanner sc = new Scanner(System.in);
    public static void initialize(){
        titulos = new ArrayList<>();
        Products produto1 = new Products(1,"Tesouro Prefixado", BigDecimal.valueOf(12.38d),BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), "01/01/2025");
        titulos.add(produto1);
    }

    public static ArrayList<Products> getTitulos() {
        return titulos;
    }
    //printa todos os investimentos do repositório e as suas caracteristicas e depois disso pede ao usuário para escolher um
    public static Products getInvestimento() {
        ArrayList<Products> listaDeInvestimentos =getTitulos();
        getListaDeInvestimento();
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        return listaDeInvestimentos.get(escolha-1);
    }
    public static void getListaDeInvestimento() {
        ArrayList<Products> listaDeInvestimentos =getTitulos();
        for (Products investimento : listaDeInvestimentos) {
            System.out.printf("%d - Nome: %s -- Investimento Mínimo: R$ %.2f -- Preço unitário: R$ %.2f -- " +
                            "Rentabilidade anual: %.2f%% -- Vencimento: %s\n",investimento.getCode(), investimento.getNome(),
                    investimento.getInvestimentoMinimo(), investimento.getPrecoUnitario(),
                    investimento.getRentabilidadeAnual().multiply(BigDecimal.valueOf(100d)),
                    investimento.getVencimento());
        }
    }
}
