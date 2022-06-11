package org.example;
import org.example.controller.MainMenuController;
import org.example.views.MainMenu;
import org.example.repository.RepositoryProducts;
import org.example.repository.RepositoryUsers;

public class App {
    public static void main( String[] args ) {
        RepositoryUsers.initialize();
        RepositoryProducts.initialize();
        MainMenuController.run();
    }
}
