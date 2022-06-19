package org.example.model;

public enum ProductsType {
    TITULOSPUBLICOS("Tesouro Direto"),
    CDB("Certificado de Depósito Bancário"),
    LCI("Letra de Crédito Imobiliário"),
    LCA("Letra de Crédito do Agronegócio");

    private final String label;

    ProductsType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
