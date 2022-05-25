package org.example.model;
import org.example.Telas.CriarProduto;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Corretora extends Usuario {

    private final ArrayList<Produtos> titulos;

    public Corretora(String nome, String login, String senha, String cnpj) {
        super(nome, login, senha, cnpj);
        this.titulos = new ArrayList<>();
        }

    private void teste(){
        Produtos produto1 = new Produtos(1,"Tesouro Prefixado", BigDecimal.valueOf(12.38d),BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), "01/01/2025");
        titulos.add(produto1);
    }

    public void relatorioClientes(){
        //implementar relatorio
    }

    public BigDecimal arrecadacao(){
        return BigDecimal.ZERO;
    }

    public void cadastrarAtualizar(){
        CriarProduto titulo = new CriarProduto();
        new CadastrarAtualizar().registerUpdate(titulos,titulo.informarProduto());
    }


//    public ArrayList<Produtos> getProdutos() {
//        return produtos;
//    }

}
