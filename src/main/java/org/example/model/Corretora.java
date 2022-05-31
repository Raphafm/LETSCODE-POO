package org.example.model;
import org.example.Repository.RepositoryProdutos;
import org.example.Telas.CriarProduto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Corretora extends Usuario {

    public Corretora(String nome, String login, String senha, String cnpj) {
        super(nome, login, senha, cnpj);
        }

    public void relatorioClientes(){
        //implementar relatorio
    }

    public BigDecimal arrecadacao(){
        return BigDecimal.ZERO;
    }

    public void cadastrarAtualizar(Scanner sc){
        CriarProduto titulo = new CriarProduto();
        new CadastrarAtualizar().registerUpdate(RepositoryProdutos.getTitulos(),titulo.informarProduto(sc));
    }


//    public ArrayList<Produtos> getProdutos() {
//        return produtos;
//    }

}
