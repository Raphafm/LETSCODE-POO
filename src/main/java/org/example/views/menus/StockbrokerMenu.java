package org.example.views.menus;
import java.util.*;


public class StockbrokerMenu extends BasicMenu {
    public String printMenu(Scanner sc) {

        System.out.println("Bem vindo ao menu da corretora");
        System.out.println("Digite:\n0 - Sair da conta\n1 - Cadastrar/Atualizar produto");
        System.out.println("2 - Obter Relatório\n3 - Obter arrecadação\n4 - Visualizar produtos por vencimento");
        System.out.println("5 - Visualizar clientes");
        System.out.println("6 - Visualizar produtos por ordem alfabética");
        System.out.print("Opcao: ");
        String option = sc.nextLine();

        return option;
    }

}
