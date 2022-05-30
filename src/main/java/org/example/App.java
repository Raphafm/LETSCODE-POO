package org.example;
import org.example.Menus.Menus;
import org.example.Repository.RepositoryProdutos;
import org.example.Repository.RepositoryUsuarios;
import org.example.model.Corretora;
import org.example.model.Produtos;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main( String[] args ) {
        RepositoryUsuarios.inicializar();
        RepositoryProdutos.inicializar();
        Menus.menuPrincipal();
    }
}
