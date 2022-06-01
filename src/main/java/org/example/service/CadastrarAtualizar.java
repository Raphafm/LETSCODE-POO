package org.example.service;
import java.util.ArrayList;
import org.example.Model.Produtos;
public class CadastrarAtualizar {

    public void registerUpdate(ArrayList<Produtos> titulos, Produtos titulo){
        int code = titulo.getCode();
        int linha = verificarExistencia(titulos, code);

        if (linha != -1){
            // atualizar
            titulos.set(linha,titulo);
        }else{
            // adicionar
            titulos.add(titulo);
        }
    }

    private int verificarExistencia(ArrayList<Produtos> titulos, int code){
        for (Produtos titulo : titulos) {
            if (titulo.getCode() == code){
             return titulos.indexOf(titulo);
            }
        }
        return -1;
    }
}
