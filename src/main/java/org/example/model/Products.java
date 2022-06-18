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
    private String name;
    private Double annualProfitability;
    private BigDecimal minInvestment;
    private BigDecimal unitPrice;
    private LocalDate dueDate;
    private int riskOfInvestment;
    private ProductsType productType;

    public Products(int code, String name, double annualProfitability, BigDecimal minInvestment,
                    BigDecimal unitPrice, LocalDate dueDate, int riskOfInvestment,
                    ProductsType productType) {
        this.code = code;
        this.name = name;
        this.annualProfitability = annualProfitability /100.d;
        this.minInvestment = minInvestment;
        this.unitPrice = unitPrice;
        this.dueDate = dueDate;
        this.riskOfInvestment = riskOfInvestment;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public double getAnnualProfitability() {
        return annualProfitability;
    }

    public BigDecimal getMinInvestment() {
        return minInvestment;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("%d - Nome: %s -- Investimento Mínimo: R$ %.2f -- Preço unitário: R$ %.2f -- " +
                        "Rentabilidade anual: %.2f%% -- Vencimento: %s\n",code, name,
                minInvestment, unitPrice, annualProfitability *100.d, dueDate);
    }

    public static List<Products> sortByDueDate(){
        List<Products> productSort = asListSorted(RepositoryProducts.getProducts(),
                Comparator.comparing(Products::getDueDate));
        return productSort;
    }

    public static List<Products> sortByABC(){
        List<Products> productSort = asListSorted(RepositoryProducts.getProducts(),
                Comparator.comparing(Products::getName));
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
