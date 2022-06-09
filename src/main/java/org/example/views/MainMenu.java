package org.example.views;
import java.util.Objects;
import java.util.Scanner;
import org.example.model.Client;
import org.example.views.AccessAccount;
import org.example.views.ClientMenu;
import org.example.views.CreateAccount;
import org.example.model.Stockbroker;
import org.example.model.User;
import org.example.views.StockbrokerMenu;

public class MainMenu {
    private static final Scanner sc = new Scanner(System.in);

    public static void mainMenu() {

        System.out.println("Bem vindo ao menu principal");
        System.out.println("Digite:\n0 - Sair\n1 - Fazer o login\n2 - Criar conta\n3 - Fazer simulação");
        System.out.print("Opcao: ");
        String option = sc.nextLine();

        switch (option) {
            case "0":
                System.out.println("Obrigado por utilizar nossos serviços, até a próxima");
                return;
            case "1":
                User usuario = AccessAccount.run(sc);
                if (Objects.isNull(usuario)) {
                    System.err.println("Usuario não encontrado!");
                } else if (usuario instanceof Stockbroker) {
                    StockbrokerMenu.stockbrokerMenu(sc, ((Stockbroker) usuario));
                } else {
                    ClientMenu.clientMenu(sc, ((Client) usuario));
                }
                break;
            case "2":
                CreateAccount.run(sc);
                break;
            case "3":
                System.out.println("simulação em construção");
                //Simulation meuInvestimento = new Simulation(RepositoryProducts.getInvestimento().getRentabilidadeAnual().doubleValue());
                //meuInvestimento.relatorio();
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
                break;
        }
        mainMenu();
    }
}
