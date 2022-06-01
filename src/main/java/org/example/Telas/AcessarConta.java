package org.example.Telas;
import org.example.Repository.RepositoryUsuarios;
import org.example.Model.Usuario;

import java.util.Scanner;

public class AcessarConta {
    public static Usuario executar(Scanner sc){
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        return RepositoryUsuarios.encontrarContaPorLoginSenha(login,senha);
    }
}

