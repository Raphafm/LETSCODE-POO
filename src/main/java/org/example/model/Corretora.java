package org.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Corretora extends Usuario {

//    private final ArrayList<Produtos> produtos;

    public Corretora(String nome, String login, String senha, String cnpj) {
        super(nome, login, senha, cnpj);
//        this.produtos = new ArrayList<Produtos>();
    }

    public void relatorioClientes(){
        //implementar relatorio
    }

    public BigDecimal arrecadacao(){
        return BigDecimal.ZERO;
    }

//    public ArrayList<Produtos> getProdutos() {
//        return produtos;
//    }
}
