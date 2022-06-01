package org.example.Repository;
import org.example.Quiz.TipoPerfilInvestidor;
import org.example.Model.Cliente;
import org.example.Model.Corretora;
import org.example.Model.Usuario;
import java.util.ArrayList;

public class RepositoryUsuarios {
    private static ArrayList<Usuario> contasLista;

    public static void inicializar(){
        contasLista = new ArrayList<>();
        Corretora corretora = new Corretora("Banco 10","banco10","123","01234567891");
        Cliente cliente1 = new Cliente("Matheus","123","123","012345678","123456", TipoPerfilInvestidor.ARROJADO);
        contasLista.add(corretora);
        contasLista.add(cliente1);
    }

    public static void addCliente(Cliente cliente){
        contasLista.add(cliente);
    }

    public static ArrayList<Usuario> getContasLista() {
        return contasLista;
    }

    public static Usuario encontrarContaPorLoginSenha(String login, String senha){
        for (Usuario usuario: contasLista) {
            if(usuario.autenticarLogin(login,senha)){
                return usuario;
            }
        }
        return null;
    }
}
