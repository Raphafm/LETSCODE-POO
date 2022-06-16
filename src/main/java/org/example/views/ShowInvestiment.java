package org.example.views;

import java.util.List;

public class ShowInvestiment {
    public static <T> void showInvestiment(List<T> listInvestiment){
        System.out.println();
        listInvestiment.forEach(System.out::print);
        System.out.println();
    }
}
