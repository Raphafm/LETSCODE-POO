package org.example.model;
import org.example.repository.RepositoryProducts;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Investiment {

    private Products product;
    private int tempoDeInvestimento;
    private BigDecimal quantiaInvestida;
    private BigDecimal rendimentos;
    private BigDecimal tributacao;
    private BigDecimal ganhoLiquido;
    private BigDecimal valoresFinais;
    private BigDecimal iof;

    public Investiment(Products product, int tempoDeInvestimento,BigDecimal quantiaInvestida) {
        this.product = product;
        this.tempoDeInvestimento = tempoDeInvestimento;
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
}
