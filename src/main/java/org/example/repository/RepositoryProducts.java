package org.example.repository;
import java.math.BigDecimal;
import org.example.model.Products;
import org.example.model.ProductsType;
import java.time.LocalDate;
import java.util.*;

public class RepositoryProducts{
    static Scanner sc = new Scanner(System.in);
    private static Map<Integer,Products> keyProducts;

    public static void initialize(){
        Products produto1 = new Products(1,"Tesouro Prefixado 2025", 12.38d,BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), LocalDate.of(2025,01,01),70, ProductsType.TITULOSPUBLICOS);
        Products produto2 = new Products(2,"Tesouro Selic 2027", 1.38d,BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), LocalDate.of(2027,01,01),70, ProductsType.TITULOSPUBLICOS);
        Products produto3 = new Products(3,"Tesouro Prefixado 2022", 1.38d,BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), LocalDate.of(2022,01,01),70, ProductsType.TITULOSPUBLICOS);

        keyProducts = new TreeMap<>();
        keyProducts.put(produto1.getCode(),produto1);
        keyProducts.put(produto2.getCode(),produto2);
        keyProducts.put(produto3.getCode(),produto3);
    }

    public static void save(Products product) {
        keyProducts.put(product.getCode(),product);
    }

    public static List<Products> getProducts() {
        ArrayList<Products> productsList= new ArrayList<>();
        productsList.addAll(keyProducts.values());
        return productsList;
    }

    //printa todos os investimentos do repositório e as suas caracteristicas e depois disso pede ao usuário para escolher um
    // TODO colocar em uma view
//    public static Products getInvestimento() {
//        printListaDeInvestimento();
//        System.out.print("Escolha uma opção: ");
//        int escolha = sc.nextInt();
//        return products.get(escolha-1);
//    }
    // TODO metodo para printar produtos em views
//    public static void printListaDeInvestimento() {
//
//        for (Products investimento : keyProducts.values()) {
//            System.out.print(investimento);
//        }
//    }

    public static Map<Integer, Products> getKeyProducts() {
        return keyProducts;
    }
}
