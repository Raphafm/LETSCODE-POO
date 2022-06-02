package org.example.Telas;
import org.example.Repository.RepositoryUsers;
import org.example.Model.User;

import java.util.Scanner;

public class AccessAccount {
    public static User run(Scanner sc){
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        return RepositoryUsers.findAccountByLoginPassword(login,senha);
    }
}

