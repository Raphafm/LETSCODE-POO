package org.example.Repository;
import org.example.quiz.TypeInvestorProfile;
import org.example.model.Client;
import org.example.model.Stockbroker;
import org.example.model.User;
import java.util.ArrayList;

public class RepositoryUsers {
    private static ArrayList<User> contasLista;

    public static void initialize(){
        contasLista = new ArrayList<>();
        Stockbroker corretora = new Stockbroker("Banco 10","banco10","123","01234567891");
        Client client1 = new Client("Matheus","123","123","012345678","123456", TypeInvestorProfile.ARROJADO);
        contasLista.add(corretora);
        contasLista.add(client1);
    }

    public static void addCliente(Client client){
        contasLista.add(client);
    }

    public static ArrayList<User> getContasLista() {
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
