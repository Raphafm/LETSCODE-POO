package org.example.model;
import org.example.controller.StockbrokerMenuController;
import org.example.repository.RepositoryProducts;
import org.example.views.creation.CreateProduct;

import java.math.BigDecimal;
import java.util.Scanner;

public class Stockbroker extends User {

    private static final BigDecimal FEES_STOCKBROKER = BigDecimal.valueOf(0.02d);

    public Stockbroker(String nome, String login, String password, String id) {
        super(nome, login, password, id);
        }

    public void registerUpdate(Scanner sc){
        RepositoryProducts.save(new CreateProduct().run(sc));
    }

    public static BigDecimal getFeesStockbroker() {
        return FEES_STOCKBROKER;
    }

    @Override
    public void accessMenu(Scanner sc) {
        StockbrokerMenuController.runStockbrokerMenu(sc, this);
    }
}
