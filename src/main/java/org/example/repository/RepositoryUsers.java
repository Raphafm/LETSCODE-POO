package org.example.repository;
import org.example.quiz.TypeInvestorProfile;
import org.example.model.Client;
import org.example.model.Stockbroker;
import org.example.model.User;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class RepositoryUsers {
    private static Set<User> contasLista;

    public static void initialize(){
        contasLista = new TreeSet<>();
        Stockbroker corretora = new Stockbroker("10 Banco 10","banco10","123","12345678901234");
        Client client1 = new Client("Matheus","123","123","12345678901","123456", TypeInvestorProfile.ARROJADO);
        contasLista.add(corretora);
        contasLista.add(client1);
    }

    public static void addCliente(Client client){
        contasLista.add(client);
    }

    public static Set<User> getContasLista() {
        return contasLista;
    }

    public static User findAccountByLoginPassword(String login, String senha){
        for (User user : contasLista) {
            if(user.autenticarLogin(login,senha)){
                return user;
            }
        }
        return null;
    }
}
