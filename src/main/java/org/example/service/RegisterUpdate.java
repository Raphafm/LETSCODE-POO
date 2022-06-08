package org.example.service;
import org.example.model.Products;
import org.example.repository.RepositoryProducts;

public class RegisterUpdate {

    public void run(Products titulo){
        if (RepositoryProducts.getKeyProducts().containsKey(titulo.getCode())){
            // atualizar
            RepositoryProducts.getKeyProducts().put(titulo.getCode(),titulo);
        }else{
            // adicionar
            RepositoryProducts.save(titulo);
        }

    }
}
