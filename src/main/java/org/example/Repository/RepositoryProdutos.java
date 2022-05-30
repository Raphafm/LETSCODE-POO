package org.example.Repository;
import org.example.model.Produtos;
import java.math.BigDecimal;
import java.util.ArrayList;

public class RepositoryProdutos {
    private static ArrayList<Produtos> titulos;

    public static void inicializar(){
        titulos = new ArrayList<>();
        Produtos produto1 = new Produtos(1,"Tesouro Prefixado", BigDecimal.valueOf(12.38d),BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), "01/01/2025");
        titulos.add(produto1);
    }

    public static ArrayList<Produtos> getTitulos() {
        return titulos;
    }
}
