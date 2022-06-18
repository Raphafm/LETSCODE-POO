package org.example.views.menus;
import java.util.*;

public class StockbrokerMenu extends BasicMenu {
    public String printMenu(Scanner sc) {

        System.out.println("Bem vindo ao menu da corretora");
        System.out.println("Digite:");
        System.out.println("\t0 - Sair da conta");
        System.out.println("\t1 - Cadastrar/Atualizar produto");
        System.out.println("\t2 - Obter Relatório");
        System.out.println("\t3 - Obter arrecadação");
        System.out.println("\t4 - Visualizar clientes");
        System.out.println("\t5 - Visualizar produtos por vencimento");
        System.out.println("\t6 - Visualizar produtos por ordem alfabética");
        System.out.print("Opcao: ");

        return sc.nextLine();
    }
}
