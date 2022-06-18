package org.example.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Investment {

    private Products product;
    private int timeInvested;
    private BigDecimal valueInvested;
    private BigDecimal profitNet;
    private BigDecimal profitStockbroker;
    private LocalDate dateInvested;

    private BigDecimal yield;
    private BigDecimal priceIof;
    private BigDecimal priceIR;
    private BigDecimal priceTotalYieldNet;
    private BigDecimal priceTotalYield;

    public Investment(Products product, int timeInvested, BigDecimal valueInvested) {
        this.product = product;
        this.timeInvested = timeInvested;
        this.valueInvested = valueInvested;
    }

    public Investment(Products product, LocalDate dateInvested, BigDecimal valueInvested) {
        this.product = product;
        this.dateInvested = dateInvested;
        this.timeInvested = (int) ChronoUnit.DAYS.between(dateInvested,LocalDate.now());
        this.valueInvested = valueInvested;
    }

    public Products getProduct() {
        return product;
    }

    public int getTimeInvested() {
        return timeInvested;
    }

    public BigDecimal getValueInvested() {
        return valueInvested;
    }

    public BigDecimal getProfitNet() {
        return profitNet;
    }

    public void setProfitNet(BigDecimal profitNet) {
        this.profitNet = profitNet;
    }

    public LocalDate getDateInvested() {
        return dateInvested;
    }

    public BigDecimal getProfitStockbroker() {
        return profitStockbroker;
    }

    public void setProfitStockbroker(BigDecimal profitStockbroker) {
        this.profitStockbroker = profitStockbroker;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public void setPriceIof(BigDecimal priceIof) {
        this.priceIof = priceIof;
    }

    public void setPriceIR(BigDecimal priceIR) {
        this.priceIR = priceIR;
    }

    public void setPriceTotalYieldNet(BigDecimal priceTotalYieldNet) {
        this.priceTotalYieldNet = priceTotalYieldNet;
    }

    public void setPriceTotalYield(BigDecimal priceTotalYield) {
        this.priceTotalYield = priceTotalYield;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public BigDecimal getPriceIof() {
        return priceIof;
    }

    public BigDecimal getPriceIR() {
        return priceIR;
    }

    public BigDecimal getPriceTotalYieldNet() {
        return priceTotalYieldNet;
    }

    public BigDecimal getPriceTotalYield() {
        return priceTotalYield;
    }
}
