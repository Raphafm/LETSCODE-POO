package org.example;
import org.example.views.MainMenu;
import org.example.repository.RepositoryProducts;
import org.example.repository.RepositoryUsers;

public class App {
    public static void main( String[] args ) {
        RepositoryUsers.initialize();
        new RepositoryProducts().initialize();
        MainMenu.mainMenu();
    }
}
