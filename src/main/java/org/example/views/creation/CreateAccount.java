package org.example.views.creation;
import org.example.controller.MainMenuController;
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

        String name;
        do {
            System.out.print("Nome: ");
            name = sc.nextLine();
        } while (validateName(name));

        String cpf;
        do {
            System.out.print("CPF: ");
            cpf = sc.nextLine();
        }while(validateCPF(cpf));
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
        }while(validatePassword(password,sc.nextLine()));

        String accountNumber;
       do{
           accountNumber = String.format("%04d", new Random().nextInt(9999));
       } while(verifyExistenceAccountNumber(accountNumber));


        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ufa! Agora falta pouco para completar a criação da sua conta, assim que \n" +
                "concluir o quiz para definir o seu perfil de investidor sua conta será criada.");

        // chamar o quiz
        int pontos = QuizInvestorProfile.quiz(sc);
        Client client = new Client(name,login, password,cpf, accountNumber, TypeInvestorProfile.getTipeInvestorPerfil(pontos));
        RepositoryUsers.addCliente(client);

        System.out.println("Parabéns, sua conta foi criada com sucesso!");
        System.out.printf("Cliente: %s %n", name);
        System.out.printf("Agência: %s %n", Stockbroker.getAGENCIA());
        System.out.printf("Conta: %s %n", accountNumber);
        System.out.printf("Perfil do investidor: %s %n", TypeInvestorProfile.getTipeInvestorPerfil(pontos));
        System.out.println("-----------------------------------------------------------------");
    }

    private static boolean validatePassword(String password1, String password2){
        if (password1.equals(password2)){
            return false;
        }
        System.out.println("As senhas não são idênticas, digite novamente!\n");
        return true;
    }

    private static boolean validateCPF(String cpf){
        if(cpf.length() != 11){
            System.out.println("CPF invalido, digite novamente!");
            return true;
        }

        if (cpf.matches("[0-9]+")) {
           return false;
        }
        System.out.println("Digite apenas números");
        System.out.println("-----------------------------------------------------------------");
        return true;
    }

    private static boolean validateName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!(Character.isAlphabetic((name.charAt(i))))) {
                System.out.println("O nome nao pode ter números");
                return true;
            }
        }
        return false;
    }

    private static void verifyExistenceCPF(String cpf){
        for (User user : RepositoryUsers.getContasLista()) {
            if(user.getIdentificador().equals(cpf)){

                System.out.println("Você já possui uma conta na corretora, não é possível criar uma nova conta");
                System.out.println("Voltando ao menu principal");
                MainMenuController.run();

            }
        }
    }

    private static boolean verifyExistenceLogin(String login){
        for (User user : RepositoryUsers.getContasLista()) {
            if(user.getLogin().equals(login)){
                System.out.println("Esse login ja existe, tente outro");
                return true;
            }
        }
        return false;
    }

    private static boolean verifyExistenceAccountNumber(String accountNumber){
        for (User user : RepositoryUsers.getContasLista()) {
            if (user instanceof Stockbroker) {
                continue;
            }
            if (((Client) user).getAccountNumber().equals(accountNumber)){
                return true;
            }
        }
        return false;
    }
}
