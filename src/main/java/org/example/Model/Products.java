package org.example.model;

import java.math.BigDecimal;
import java.math.MathContext;

public class Products {

    private final int code;
    private String nome;
    private BigDecimal rentabilidadeAnual;
    private BigDecimal investimentoMinimo;
    private BigDecimal precoUnitario;
    private String vencimento;

    public Products(int code, String nome, BigDecimal rentabilidadeAnual, BigDecimal investimentoMinimo,
                    BigDecimal precoUnitario, String vencimento) {
        this.code = code;
        this.nome = nome;
        this.rentabilidadeAnual = rentabilidadeAnual.divide(BigDecimal.valueOf(100.d), new MathContext(2));
        this.investimentoMinimo = investimentoMinimo;
        this.precoUnitario = precoUnitario;
        this.vencimento = vencimento;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getRentabilidadeAnual() {
        return rentabilidadeAnual;
    }

    public BigDecimal getInvestimentoMinimo() {
        return investimentoMinimo;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRentabilidadeAnual(BigDecimal rentabilidadeAnual) {
        this.rentabilidadeAnual = rentabilidadeAnual;
    }

    public void setInvestimentoMinimo(BigDecimal investimentoMinimo) {
        this.investimentoMinimo = investimentoMinimo;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public int getCode() {
        return code;
    }


}
