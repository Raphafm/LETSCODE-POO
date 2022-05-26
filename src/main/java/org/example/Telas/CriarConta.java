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

        // chamar o quiz
        int pontos = QuizPerfilInvestidor.quiz(sc);
        Cliente cliente = new Cliente(nome,login,senha1,cpf,numeroConta, TipoPerfilInvestidor.getTipoPerfilInvestidor(pontos));
        RepositoryUsuarios.addCliente(cliente);


    }

    private boolean validarSenha(String senha1, String senha2){
        if (senha1.equals(senha2)){
            return false;
        }
        System.err.println("As senhas não são identicas, digite novamente!");
        return true;
    }

    private boolean validarCPF(String cpf){
        if(cpf.length() != 11){
            System.err.println("CPF invalido, digite novamente!");
            return true;
        }
        return false;
    }

    private void verificarExistencia(String cpf){
        for (Usuario usuario : RepositoryUsuarios.getContasLista()) {
            if(usuario.getIdentificador().equals(cpf)){
                System.out.println("Você já possui uma conta na corretora, não é possível criar uma nova conta");
                Menus.menuPrincipal();
            }
        }
    }

}
