package org.example.views;
import org.example.model.Products;
import java.util.List;

public class ShowProducts<T> {
    public static <T> void showProducts(List<T> listProducts){
        System.out.println();
        listProducts.forEach(products -> System.out.print(products));
        System.out.println();
    }

//    public static void showProductsSort() {
//        ArrayList<Produtos> listaDeInvestimentos =getTitulos();
//        int i =0;
//        for (Produtos investimento : listaDeInvestimentos) {
//            i+=1;
//            System.out.printf("%d - Nome: %s -- Investimento Mínimo: R$ %.2f -- Preço unitário: R$ %.2f -- " +
//                            "Rentabilidade anual: %.2f%% -- Vencimento: %s\n",i, investimento.getNome(),
//                    investimento.getInvestimentoMinimo(), investimento.getPrecoUnitario(),
//                    investimento.getRentabilidadeAnual().multiply(BigDecimal.valueOf(100d)),
//                    investimento.getVencimento());
//        }
//    }


}
