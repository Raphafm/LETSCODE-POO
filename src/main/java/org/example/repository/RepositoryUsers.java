package org.example.repository;
import org.example.model.TypeInvestorProfile;
import org.example.model.Client;
import org.example.model.Stockbroker;
import org.example.model.User;

import java.util.*;

public class RepositoryUsers {
    private static Set<User> listAccount;

    public static void initialize(){
        listAccount = new TreeSet<>();
        Stockbroker stockbroker = new Stockbroker("10 Banco 10","banco10","123","12345678901234");
        Client client1 = new Client("Matheus","123","123","12345678901","123456", TypeInvestorProfile.ARROJADO);
        listAccount.add(stockbroker);
        listAccount.add(client1);
    }

    public static void addClient(Client client){
        listAccount.add(client);
    }

    public static Set<User> getListAccount() {
        return listAccount;
    }

    public static User findAccountByLoginPassword(String login, String password){
        for (User user : listAccount) {
            if(user.loginValidate(login, password)){
                return user;
            }
        }
        return null;
    }

    public static Set<Client> getClientList() {
        Set<Client> clientList = new HashSet<>();
        for (User user : listAccount) {
            if(user instanceof Client){
                clientList.add((Client)user);
            }
        }
        return clientList;
    }
}
