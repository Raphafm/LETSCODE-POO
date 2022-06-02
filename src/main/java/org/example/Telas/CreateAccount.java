package org.example.Telas;
import org.example.menus.MainMenu;
import org.example.quiz.QuizInvestorProfile;
import org.example.quiz.TypeInvestorProfile;
import org.example.Repository.RepositoryUsers;
import org.example.Model.Client;
import org.example.Model.User;
import java.util.Random;
import java.util.Scanner;

public class CreateAccount {
    public void run(Scanner sc){
        System.out.println("Informe as seguintes informações");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        String cpf;
        do {
            System.out.print("CPF: ");
            cpf = sc.nextLine();
        }while(validateCPF(cpf));
        verifyExistence(cpf);

        System.out.print("Login: ");
        String login = sc.nextLine();//verificar se o login existe

        String senha1;
        String senha2;
        do{
            System.out.print("Senha: ");
            senha1 = sc.nextLine();
            System.out.print("Escreva novamente a senha: ");
            senha2 = sc.nextLine();
        }while(validatePassword(senha1,senha2));

        // criar um número da conta
        String numeroConta = String.format("%04d", new Random().nextInt(9999));//nao pode ser uma conta que ja existe

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ufa! Agora falta pouco para completar a criação da sua conta, assim que \n" +
                "concluir o quiz para definir o seu perfil de investidor sua conta será criada.");

        // chamar o quiz
        int pontos = QuizInvestorProfile.quiz(sc);
        Client client = new Client(nome,login,senha1,cpf,numeroConta, TypeInvestorProfile.getTipeInvestorPerfil(pontos));
        RepositoryUsers.addCliente(client);

        System.out.println("Parabéns, sua conta foi criada com sucesso!");
        System.out.printf("Client: %s %n",nome);
        System.out.printf("Agência: %s %n", client.getAGENCIA());
        System.out.printf("Conta: %s %n", numeroConta);
        System.out.println("-----------------------------------------------------------------");
    }

    private boolean validatePassword(String senha1, String senha2){
        if (senha1.equals(senha2)){
            return false;
        }
        System.err.println("As senhas não são idênticas, digite novamente!\n");
        return true;
    }

    private boolean validateCPF(String cpf){
        if(cpf.length() != 11){
            System.out.println("CPF invalido, digite novamente!");
            return true;
        }
        return false;
    }

    private void verifyExistence(String cpf){
        for (User user : RepositoryUsers.getContasLista()) {
            if(user.getIdentificador().equals(cpf)){
                System.err.println("Você já possui uma conta na corretora, não é possível criar uma nova conta");
                MainMenu.mainMenu();
            }
        }
    }
}
