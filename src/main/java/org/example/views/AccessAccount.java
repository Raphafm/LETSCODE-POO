package org.example.views;
import org.example.repository.RepositoryUsers;
import org.example.model.User;

import java.util.Scanner;

public class  AccessAccount {
    public static User run(Scanner sc){
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String password = sc.nextLine();

        return RepositoryUsers.findAccountByLoginPassword(login, password);
    }
}

