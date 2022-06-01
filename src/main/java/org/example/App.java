package org.example;
import org.example.menus.MainMenu;
import org.example.Repository.RepositoryProducts;
import org.example.Repository.RepositoryUsers;

public class App {
    public static void main( String[] args ) {
        RepositoryUsers.initialize();
        RepositoryProducts.initialize();
        MainMenu.mainMenu();
    }
}
