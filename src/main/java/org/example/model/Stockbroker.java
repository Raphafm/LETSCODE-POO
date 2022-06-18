package org.example.model;
import org.example.repository.RepositoryProducts;
import org.example.views.creation.CreateProduct;

import java.util.Scanner;

public class Stockbroker extends User {

    public Stockbroker(String nome, String login, String password, String id) {
        super(nome, login, password, id);
        }

    public void registerUpdate(Scanner sc){
        RepositoryProducts.save(new CreateProduct().run(sc));
    }

}
