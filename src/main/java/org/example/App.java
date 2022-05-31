package org.example;
import org.example.Menus.Menus;
import org.example.Repository.RepositoryProdutos;
import org.example.Repository.RepositoryUsuarios;

public class App {
    public static void main( String[] args ) {
        RepositoryUsuarios.inicializar();
        RepositoryProdutos.inicializar();
        Menus.menuPrincipal();
    }
}
