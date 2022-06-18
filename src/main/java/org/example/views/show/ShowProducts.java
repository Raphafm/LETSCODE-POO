package org.example.views.show;

import java.util.List;

public class ShowProducts {
    public static <T> void showProducts(List<T> listProducts){
        System.out.println();
        listProducts.forEach(System.out::print);
        System.out.println();
    }
}
