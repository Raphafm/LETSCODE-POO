package org.example.model;
import org.example.Repository.RepositoryProdutos;
import org.example.Telas.CriarProduto;
import java.math.BigDecimal;
import java.util.ArrayList;

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

    public void cadastrarAtualizar(){
        CriarProduto titulo = new CriarProduto();
        new CadastrarAtualizar().registerUpdate(RepositoryProdutos.getTitulos(),titulo.informarProduto());
    }


//    public ArrayList<Produtos> getProdutos() {
//        return produtos;
//    }

}
