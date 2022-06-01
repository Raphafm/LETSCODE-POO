package org.example.Model;

import org.example.Quiz.TipoPerfilInvestidor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Cliente extends Usuario {

    private TipoPerfilInvestidor tipoPerfilInvestidor;
    private BigDecimal valorDisponivel;
    private String numeroConta;
    private final String AGENCIA = "0000-1";
    private String extrato;


//    private final ArrayList<Inventimentos> inventimentos;

    public Cliente(String nome, String login, String senha, String cpf, String numeroConta, TipoPerfilInvestidor tipoPerfilInvestidor) {
        super(nome, login, senha, cpf);
        this.numeroConta = numeroConta;
        this.valorDisponivel = BigDecimal.ZERO;
        this.tipoPerfilInvestidor = tipoPerfilInvestidor;
        this.extrato =String.format("%-20s %-10s %n","Data","Valor (R$)");

//        this.inventimentos = new ArrayList<Inventimentos>();
//        public BigDecimal resgatar(){
//            return BigDecimal.ZERO;
//        }
    }

    public BigDecimal extrato() {
        return BigDecimal.ZERO;
    }

    public void sacar(BigDecimal valorSaque) {
        if (this.valorDisponivel.compareTo(valorSaque) >= 0) {
            System.out.printf("Valor disponivel anteriormente: R$ %.2f %n", this.valorDisponivel);
            this.valorDisponivel = this.valorDisponivel.subtract(valorSaque);
            System.out.printf("Valor do saque: - R$ %.2f %n", valorSaque);
            System.out.printf("Valor disponível atualizado: R$ %.2f %n", this.valorDisponivel);
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            this.extrato += String.format("%-20s -%-10.2f %n",data,valorSaque);
            return;
        }
        System.err.printf("Saldo insuficiente! %n Saldo Atual: R$ %.2f", this.valorDisponivel);
    }

    public void depositar(BigDecimal valorDeposito) {
        System.out.printf("Valor disponivel anteriormente: R$ %.2f %n", this.valorDisponivel);
        this.valorDisponivel = this.valorDisponivel.add(valorDeposito);
        System.out.printf("Valor do deposito: + R$ %.2f %n", valorDeposito);
        System.out.printf("Valor disponível atualizado: R$ %.2f %n", this.valorDisponivel);
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.extrato += String.format("%-20s +%-10.2f %n",data,valorDeposito);
    }

    public BigDecimal getValorDisponivel() {
        return valorDisponivel;
    }

    public void setValorDisponivel(BigDecimal valorDisponivel) {
        this.valorDisponivel = valorDisponivel;
    }

    public String getAGENCIA() {
        return AGENCIA;
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


    @Override
    public String toString() {
        return "Cliente{" +
                "tipoPerfilInvestidor=" + tipoPerfilInvestidor +
                ", valorDisponivel=" + valorDisponivel +
                ", numeroConta='" + numeroConta + '\'' +
                ", AGENCIA='" + AGENCIA + '\'' +
                '}';
    }

    public String imprimirExtrato() {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return extrato + String.format("------------------------------------------------------------ %n" +
                "%-20s  %-10.2f %n",data,this.valorDisponivel);
    }
}
