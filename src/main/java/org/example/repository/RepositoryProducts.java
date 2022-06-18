package org.example.repository;
import java.math.BigDecimal;
import org.example.model.Products;
import org.example.model.ProductsType;
import java.time.LocalDate;
import java.util.*;

public class RepositoryProducts{
    private static Map<Integer,Products> keyProducts;

    public static void initialize(){
        Products product1 = new Products(1,"Tesouro Prefixado 2025", 12.38d,BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), LocalDate.of(2025,1,1),70, ProductsType.TITULOSPUBLICOS);
        Products product2 = new Products(2,"Tesouro Selic 2027", 1.38d,BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), LocalDate.of(2027,1,1),70, ProductsType.TITULOSPUBLICOS);
        Products product3 = new Products(3,"Tesouro Prefixado 2022", 1.38d,BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), LocalDate.of(2022,1,1),70, ProductsType.TITULOSPUBLICOS);

        keyProducts = new TreeMap<>();
        keyProducts.put(product1.getCode(),product1);
        keyProducts.put(product2.getCode(), product2);
        keyProducts.put(product3.getCode(), product3);
    }

    public static void save(Products product) {
        keyProducts.put(product.getCode(),product);
    }

    public static List<Products> getProducts() {
        return new ArrayList<>(keyProducts.values());
    }

    public static Map<Integer, Products> getKeyProducts() {
        return keyProducts;
    }
}
