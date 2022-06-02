package org.example.Model;
import org.example.Repository.RepositoryProducts;
import org.example.Telas.CreateProduct;
import org.example.service.RegisterUpdate;
import java.math.BigDecimal;
import java.util.Scanner;

public class Stockbroker extends User {

    public Stockbroker(String nome, String login, String senha, String cnpj) {
        super(nome, login, senha, cnpj);
        }

    public void relatorioClientes(){
        //implementar relatorio
    }

    public BigDecimal arrecadacao(){
        return BigDecimal.ZERO;
    }

    public void registerUpdate(Scanner sc){
        CreateProduct titulo = new CreateProduct();
        new RegisterUpdate().run(RepositoryProducts.getTitulos(),titulo.run(sc));
    }


//    public ArrayList<Products> getProdutos() {
//        return produtos;
//    }

}
