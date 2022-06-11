package org.example.model;
import org.example.repository.RepositoryProducts;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Products{

    private final Integer code;
    private String nome;
    private Double rentabilidadeAnual;
    private BigDecimal investimentoMinimo;
    private BigDecimal precoUnitario;
    private LocalDate vencimento;
    private int porcentagemRiscoDeInvestimento;
    private ProductsType tipoDoProduto;

    public Products(int code, String nome, double rentabilidadeAnual, BigDecimal investimentoMinimo,
                    BigDecimal precoUnitario, LocalDate vencimento, int porcentagemRiscoDeInvestimento,
                    ProductsType tipoDoProduto) {
        this.code = code;
        this.nome = nome;
        this.rentabilidadeAnual = rentabilidadeAnual/100.d;
        this.investimentoMinimo = investimentoMinimo;
        this.precoUnitario = precoUnitario;
        this.vencimento = vencimento;
        this.porcentagemRiscoDeInvestimento = porcentagemRiscoDeInvestimento;
        this.tipoDoProduto = tipoDoProduto;
    }

    public String getNome() {
        return nome;
    }

    public double getRentabilidadeAnual() {
        return rentabilidadeAnual;
    }

    public BigDecimal getInvestimentoMinimo() {
        return investimentoMinimo;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRentabilidadeAnual(double rentabilidadeAnual) {
        this.rentabilidadeAnual = rentabilidadeAnual;
    }

    public void setInvestimentoMinimo(BigDecimal investimentoMinimo) {
        this.investimentoMinimo = investimentoMinimo;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("%d - Nome: %s -- Investimento Mínimo: R$ %.2f -- Preço unitário: R$ %.2f -- " +
                        "Rentabilidade anual: %.2f%% -- Vencimento: %s\n",code, nome,
                investimentoMinimo, precoUnitario, rentabilidadeAnual*100.d, vencimento);
    }

    public static List<Products> ordenarPorVencimento(){
        List<Products> productSort = asListSorted(RepositoryProducts.getProducts(),
                Comparator.comparing(Products::getVencimento));
        return productSort;
    }

    public static List<Products> ordemAlfabetica(){
        List<Products> productSort = asListSorted(RepositoryProducts.getProducts(),
                Comparator.comparing(Products::getNome));
        return productSort;
    }

    private static List<Products> asListSorted(List<Products> productsList,Comparator<Products> comparator){
        if(Objects.nonNull(comparator)) {
            Collections.sort(productsList, comparator);
        }
        return productsList;
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return ((Products)o).code.equals(this.code);
    }


}
