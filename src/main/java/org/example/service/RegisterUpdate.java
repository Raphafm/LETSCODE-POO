package org.example.service;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;

import java.util.ArrayList;

public class RegisterUpdate {

    public void run(ArrayList<Products> titulos, Products titulo){
        int code = titulo.getCode();
        int linha = verificarExistencia(titulos, code);

        if (linha != -1){
            // atualizar
            titulos.set(linha,titulo);
        }else{
            // adicionar
            RepositoryProducts.save(titulo);
        }
    }

    private int verificarExistencia(ArrayList<Products> titulos, int code){
        for (Products titulo : titulos) {
            if (titulo.getCode() == code){
             return titulos.indexOf(titulo);
            }
        }
        return -1;
    }
}
