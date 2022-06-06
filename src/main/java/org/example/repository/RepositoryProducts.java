package org.example.repository;
import java.math.BigDecimal;
import org.example.model.Products;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class RepositoryProducts{
    private static ArrayList<Products> products;
    static Scanner sc = new Scanner(System.in);


    public void initialize(){
        products = new ArrayList<>();
        Products produto1 = new Products(1,"Tesouro Prefixado", BigDecimal.valueOf(12.38d),BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), "01/01/2025");
        products.add(produto1);
    }


    public static void save(Products product) {
        products.add(product);
    }

    public static ArrayList<Products> getProducts() {
        return products;
    }

    //printa todos os investimentos do repositório e as suas caracteristicas e depois disso pede ao usuário para escolher um
    // TODO colocar em uma view
    public static Products getInvestimento() {
        printListaDeInvestimento();
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        return products.get(escolha-1);
    }

    public static void printListaDeInvestimento() {
        ArrayList<Products> listaDeInvestimentos =getProducts();
        for (Products investimento : listaDeInvestimentos) {
            System.out.println(investimento);
        }
    }

}
