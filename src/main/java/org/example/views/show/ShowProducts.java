package org.example.views.show;

import java.util.List;

public class ShowProducts {
    public static <T> void showProducts(List<T> listProducts){
        System.out.println();
        header();
        listProducts.forEach(System.out::print);
        System.out.println();
    }

    private static void header() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-30s %-30s %-30s %-20s%n", "Código", "Nome", "Investimento Mínimo (R$)",
                "Rentabilidade anual (%)", "Vencimento");
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
