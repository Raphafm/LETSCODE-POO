package org.example;
import org.example.controller.MainMenuController;
import org.example.repository.RepositoryInvestment;
import org.example.repository.RepositoryProducts;
import org.example.repository.RepositoryUsers;

public class App {
    public static void main( String[] args ) {

        RepositoryUsers.initialize();
        RepositoryProducts.initialize();
        RepositoryInvestment.initialize();
        MainMenuController.run();
    }
}
