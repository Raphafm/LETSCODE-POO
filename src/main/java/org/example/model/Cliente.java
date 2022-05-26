package org.example.model;

import org.example.Quiz.TipoPerfilInvestidor;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Cliente extends Usuario {

    private TipoPerfilInvestidor tipoPerfilInvestidor;
    private BigDecimal valor;
    private String numeroConta;
    private final String AGENCIA = "0000-1";


//    private final ArrayList<Inventimentos> inventimentos;

    public Cliente(String nome, String login, String senha, String cpf, String numeroConta, TipoPerfilInvestidor tipoPerfilInvestidor) {
        super(nome, login, senha, cpf);
        this.numeroConta = numeroConta;
        this.tipoPerfilInvestidor = tipoPerfilInvestidor;
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
