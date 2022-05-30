package org.example.Telas;
import org.example.Menus.Menus;
import org.example.Quiz.QuizPerfilInvestidor;
import org.example.Quiz.TipoPerfilInvestidor;
import org.example.Repository.RepositoryUsuarios;
import org.example.model.Cliente;
import org.example.model.Usuario;

import java.util.Random;
import java.util.Scanner;

public class CriarConta {
    public void excecutar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe as seguintes informações");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        String cpf;
        do {
            System.out.print("CPF: ");
            cpf = sc.nextLine();
        }while(validarCPF(cpf));
        verificarExistencia(cpf);

        System.out.print("Login: ");
        String login = sc.nextLine();

        String senha1;
        String senha2;
        do{
            System.out.print("Senha: ");
            senha1 = sc.nextLine();
            System.out.print("Escreva novamente a senha: ");
            senha2 = sc.nextLine();
        }while(validarSenha(senha1,senha2));

        // criar um numero da conta
        String numeroConta = String.format("%04d", new Random().nextInt());

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Ufa! Agora falta pouco para completar a criação da sua conta, assim que \n" +
                "concluir o quiz para definir o seu perfil de investidor sua conta será criada.");

        // chamar o quiz
        int pontos = QuizPerfilInvestidor.quiz(sc);
        Cliente cliente = new Cliente(nome,login,senha1,cpf,numeroConta, TipoPerfilInvestidor.getTipoPerfilInvestidor(pontos));
        RepositoryUsuarios.addCliente(cliente);

        System.out.println("Parabéns, sua conta foi criada com sucesso!");
        System.out.printf("Cliente: %s %n",nome);
        System.out.printf("Agência: %s %n", cliente.getAGENCIA());
        System.out.printf("Conta: %s %n", numeroConta);
        System.out.println("-----------------------------------------------------------------");


    }

    private boolean validarSenha(String senha1, String senha2){
        if (senha1.equals(senha2)){
            return false;
        }
        System.err.println("As senhas não são idênticas, digite novamente!");
        System.out.println();
        return true;
    }

    private boolean validarCPF(String cpf){
        if(cpf.length() != 11){
            System.err.println("CPF invalido, digite novamente!");
            System.out.println();
            return true;
        }
        return false;
    }

    private void verificarExistencia(String cpf){
        for (Usuario usuario : RepositoryUsuarios.getContasLista()) {
            if(usuario.getIdentificador().equals(cpf)){
                System.err.println("Você já possui uma conta na corretora, não é possível criar uma nova conta");
                Menus.menuPrincipal();
            }
        }
    }

}
