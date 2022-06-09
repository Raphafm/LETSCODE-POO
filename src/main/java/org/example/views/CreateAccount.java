package org.example.views;
import org.example.model.Stockbroker;
import org.example.model.TypeInvestorProfile;
import org.example.repository.RepositoryUsers;
import org.example.model.Client;
import org.example.model.User;
import java.util.Random;
import java.util.Scanner;

public class CreateAccount {
    public static void run(Scanner sc){
        System.out.println("Informe as seguintes informações");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        String cpf;
        // TODO arrumar validateCPF
        do {
            System.out.print("CPF: ");
            cpf = sc.nextLine();
        }while(validateCPF(cpf));
        verifyExistence(cpf);

        System.out.print("Login: ");
        // TODO verificar se o login ja existe
        String login = sc.nextLine();

        String senha1;
        String senha2;
        do{
            System.out.print("Senha: ");
            senha1 = sc.nextLine();
            System.out.print("Escreva novamente a senha: ");
            senha2 = sc.nextLine();
        }while(validatePassword(senha1,senha2));

        // TODO verifica se numeroConta ja existe
        String numeroConta = String.format("%04d", new Random().nextInt(9999));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ufa! Agora falta pouco para completar a criação da sua conta, assim que \n" +
                "concluir o quiz para definir o seu perfil de investidor sua conta será criada.");

        // chamar o quiz
        int pontos = QuizInvestorProfile.quiz(sc);
        Client client = new Client(nome,login,senha1,cpf,numeroConta, TypeInvestorProfile.getTipeInvestorPerfil(pontos));
        RepositoryUsers.addCliente(client);

        System.out.println("Parabéns, sua conta foi criada com sucesso!");
        System.out.printf("Cliente: %s %n",nome);
        System.out.printf("Agência: %s %n", Stockbroker.getAGENCIA());
        System.out.printf("Conta: %s %n", numeroConta);
        System.out.printf("Perfil do investidor: %s %n", TypeInvestorProfile.getTipeInvestorPerfil(pontos));
        System.out.println("-----------------------------------------------------------------");
    }

    private static boolean validatePassword(String senha1, String senha2){
        if (senha1.equals(senha2)){
            return false;
        }
        System.err.println("As senhas não são idênticas, digite novamente!\n");
        return true;
    }

    private static boolean validateCPF(String cpf){
        if(cpf.length() != 11){
            System.err.println("CPF invalido, digite novamente!");
            return true;
        }
        try{
            Integer.parseInt(cpf);
        } catch (NumberFormatException ex){
            System.err.println("Digite apenas números.");
        }
        return false;
    }

    private static void verifyExistence(String cpf){
        for (User user : RepositoryUsers.getContasLista()) {
            if(user.getIdentificador().equals(cpf)){
                System.err.println("Você já possui uma conta na corretora, não é possível criar uma nova conta");
                MainMenu.mainMenu();
            }
        }
    }
}
