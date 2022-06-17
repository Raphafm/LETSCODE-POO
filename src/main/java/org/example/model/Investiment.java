package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Investiment {

    private Products product;
    private int tempoDeInvestimento;
    private BigDecimal quantiaInvestida;
    private BigDecimal rendimentos;
    private BigDecimal tributacao;
    private BigDecimal ganhoLiquido;
    private BigDecimal ganhoCoretora;
    private BigDecimal valoresFinais;
    private BigDecimal iof;
    private LocalDate diaDoInvenstimento;

    public Investiment(Products product, int tempoDeInvestimento, BigDecimal quantiaInvestida) {
        this.product = product;
        this.tempoDeInvestimento = tempoDeInvestimento;
        this.quantiaInvestida = quantiaInvestida;
    }

    public Investiment(Products product, LocalDate diaDoInvenstimento,BigDecimal quantiaInvestida) {
        this.product = product;
        this.diaDoInvenstimento = diaDoInvenstimento;
        this.tempoDeInvestimento = (int) ChronoUnit.DAYS.between(diaDoInvenstimento,LocalDate.now());
        this.quantiaInvestida = quantiaInvestida;
    }

    public Products getProduct() {
        return product;
    }

    public int getTempoDeInvestimento() {
        return tempoDeInvestimento;
    }

    public BigDecimal getQuantiaInvestida() {
        return quantiaInvestida;
    }

    public BigDecimal getRendimentos() {
        return rendimentos;
    }

    public BigDecimal getTributacao() {
        return tributacao;
    }

    public BigDecimal getGanhoLiquido() {
        return ganhoLiquido;
    }

    public BigDecimal getValoresFinais() {
        return valoresFinais;
    }

    public BigDecimal getIof() {
        return iof;
    }

    public void setTempoDeInvestimento(int tempoDeInvestimento) {
        this.tempoDeInvestimento = tempoDeInvestimento;
    }

    public void setQuantiaInvestida(BigDecimal quantiaInvestida) {
        this.quantiaInvestida = quantiaInvestida;
    }

    public void setRendimentos(BigDecimal rendimentos) {
        this.rendimentos = rendimentos;
    }

    public void setTributacao(BigDecimal tributacao) {
        this.tributacao = tributacao;
    }

    public void setGanhoLiquido(BigDecimal ganhoLiquido) {
        this.ganhoLiquido = ganhoLiquido;
    }

    public void setValoresFinais(BigDecimal valoresFinais) {
        this.valoresFinais = valoresFinais;
    }

    public void setIof(BigDecimal iof) {
        this.iof = iof;
    }

    public LocalDate getDiaDoInvenstimento() {
        return diaDoInvenstimento;
    }

    public BigDecimal getGanhoCoretora() {
        return ganhoCoretora;
    }

    public void setGanhoCoretora(BigDecimal ganhoCoretora) {
        this.ganhoCoretora = ganhoCoretora;
    }
}
