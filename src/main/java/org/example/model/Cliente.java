package org.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Cliente extends Usuario {

//    private Tipoinvestidor tipoinvestidor;
    private BigDecimal valor;
//    private final ArrayList<Inventimentos> inventimentos;

    public Cliente(String nome, String login, String senha, String cpf) {
        super(nome, login, senha, cpf);
//        this.inventimentos = new ArrayList<Inventimentos>();
    }

    public BigDecimal extrato(){
        return BigDecimal.ZERO;
    }

    public boolean tranferencia(){
        return true;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

//    public Tipoinvestidor getTipoinvestidor() {
//        return tipoinvestidor;
//    }
//
//    public void setTipoinvestidor(Tipoinvestidor tipoinvestidor) {
//        this.tipoinvestidor = tipoinvestidor;
//    }
//
//    public ArrayList<Inventimentos> getInventimentos() {
//        return inventimentos;
//    }

}
