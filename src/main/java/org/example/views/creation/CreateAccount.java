package org.example.views.creation;
import org.example.controller.MainMenuController;
import org.example.controller.validations.ValidateCPF;
import org.example.controller.validations.ValidateName;
import org.example.model.*;
import org.example.repository.RepositoryUsers;
import org.example.views.show.ShowAccount;

import java.util.Random;
import java.util.Scanner;

public class CreateAccount {
    public static void run(Scanner sc){
        System.out.println("Informe as seguintes informações");

        System.out.print("Nome: ");
        String name = ValidateName.run(sc);

        System.out.print("Cpf: ");
        String cpf = ValidateCPF.run(sc);
        verifyExistenceCPF(cpf);

        String login;
        do {
            System.out.print("Login: ");
            login = sc.nextLine();
        } while (verifyExistenceLogin(login));

        String password;
        do{
            System.out.print("Senha: ");
            password = sc.nextLine();
            System.out.print("Escreva novamente a senha: ");
        }while(verifyPassword(password,sc.nextLine()));

        String accountNumber;
       do{
           accountNumber = String.format("%04d", new Random().nextInt(9999));
       } while(verifyExistenceAccountNumber(accountNumber));


        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ufa! Agora falta pouco para completar a criação da sua conta, assim que \n" +
                "concluir o quiz para definir o seu perfil de investidor sua conta será criada.");

        // chamar o quiz
        int pontos = QuizInvestorProfile.quiz(sc);
        Client client = new Client(name,login, password,cpf, accountNumber, TypeInvestorProfile.getTypeInvestorProfile(pontos));
        RepositoryUsers.addClient(client);

        System.out.println("Parabéns, sua conta foi criada com sucesso!");

        ShowAccount.run(client);
    }

    private static boolean verifyPassword(String password1, String password2){
        if (password1.equals(password2)){
            return false;
        }
        System.out.println(Cores.RED);
        System.out.println("As senhas não são idênticas, digite novamente!");
        System.out.println(Cores.RESET);
        return true;
    }
    private static void verifyExistenceCPF(String cpf){
        for (User user : RepositoryUsers.getListAccount()) {
            if(user.getId().equals(cpf)){
                System.out.println(Cores.RED);
                System.out.println("Você já possui uma conta na corretora, não é possível criar uma nova conta");
                System.out.println("Voltando ao menu principal");
                System.out.println(Cores.RESET);
                MainMenuController.run();
            }
        }
    }
    private static boolean verifyExistenceLogin(String login){
        for (User user : RepositoryUsers.getListAccount()) {
            if(user.getLogin().equals(login)){
                System.out.println(Cores.RED);
                System.out.println("Esse login ja existe, tente outro");
                System.out.println(Cores.RESET);
                return true;
            }
        }
        return false;
    }
    private static boolean verifyExistenceAccountNumber(String accountNumber){
        for (Client client : RepositoryUsers.getClientList()) {
            if ((client.getAccountNumber().equals(accountNumber))){
                return true;
            }
        }
        return false;
    }
}
