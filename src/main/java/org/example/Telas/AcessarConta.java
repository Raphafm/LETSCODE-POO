package org.example.Telas;
import org.example.Repository.RepositoryUsuarios;
import org.example.model.Usuario;

import java.util.Scanner;

public class AcessarConta {
    public static Usuario executar(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        return RepositoryUsuarios.encontrarContaPorLoginSenha(login,senha);
    }
}

