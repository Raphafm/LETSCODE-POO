package org.example;

import org.example.model.CadastrarAtualizar;
import org.example.model.Produtos;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CadastrarAtualizarTest {
    @Test
    public void teste1(){
        ArrayList<Produtos> titulos = new ArrayList<>();


        CadastrarAtualizar obj1 = new CadastrarAtualizar();
        Produtos produto1 = new Produtos(1,"Tesouro Prefixado", BigDecimal.valueOf(12.38d),BigDecimal.valueOf(36.89d),BigDecimal.valueOf(737.98d), "01/01/2025");
        titulos.add(produto1);

//        registerUpdate();
//
//        assertEquals(true,obj1.verificarExistencia(titulos,produto1));
    }

}
