package org.example.controller.service;
import org.example.model.EnumFees;
import org.example.model.Investment;
import org.example.views.show.ShowYields;

import java.math.BigDecimal;

public class Calculator {

    private static final BigDecimal FEES_STOCKBROKER = BigDecimal.valueOf(0.02d);

    public static void run(Investment investment) {
        BigDecimal dailyFees = annualFeesToDailyFees(investment.getProduct().getAnnualProfitability());
        BigDecimal yield = yields(investment.getValueInvested(),dailyFees, investment.getTimeInvested());
        BigDecimal priceIof = valueIof(yield, investment.getTimeInvested());
        BigDecimal priceIR = valueIR(yield, investment.getTimeInvested(), priceIof);
        BigDecimal priceYieldNet = yieldNet(priceIR,yield,priceIof);

        investment.setProfitStockbroker(priceYieldNet.multiply(FEES_STOCKBROKER));
        BigDecimal priceTotalYieldNet = totalYieldNet(investment.getValueInvested(),
                priceYieldNet.subtract(investment.getProfitStockbroker()));
        BigDecimal priceTotalYield = totalYield(investment.getValueInvested(),yield);

        investment.setYield(yield);
        investment.setPriceIof(priceIof);
        investment.setPriceIR(priceIR);
        investment.setPriceTotalYieldNet(priceTotalYieldNet);
        investment.setPriceTotalYield(priceTotalYield);

    }

    private static BigDecimal annualFeesToDailyFees(double annualFees){
        return BigDecimal.valueOf(Math.pow((1.0d+ annualFees),1.0d/252.0d)-1.0d);
    }

    private static BigDecimal yields(BigDecimal valueInvested, BigDecimal dailyFees, int timeInvestedDays) {
        return  BigDecimal.ONE.add(dailyFees).pow(timeInvestedDays).multiply(valueInvested).subtract(valueInvested);
    }

    private static BigDecimal valueIof(BigDecimal yield, int timeInvestedDays) {
        BigDecimal txIof = timeInvestedDays<30? BigDecimal.valueOf((2880d-96d*timeInvestedDays)/2900d) : BigDecimal.ZERO;
        return yield.multiply(txIof);
    }

    private static BigDecimal valueIR(BigDecimal yield, int timeInvestedDays, BigDecimal priceIof) {
        BigDecimal taxa = BigDecimal.ONE;
        for (int i = 0; i < EnumFees.values().length; i++) {
            if (EnumFees.values()[i].getTimeDays() >= timeInvestedDays) {
                taxa = BigDecimal.valueOf(EnumFees.values()[i].getFees());
                break;
            }
        }
        return taxa.multiply(yield.subtract(priceIof));
    }

    private static BigDecimal yieldNet(BigDecimal priceIR, BigDecimal yield, BigDecimal priceIof) {
        return yield.subtract(priceIR).subtract(priceIof);
    }

    private static BigDecimal totalYield(BigDecimal valueInvested,BigDecimal yield){
        return valueInvested.add(yield);
    }

    private static BigDecimal totalYieldNet(BigDecimal valueInvested,BigDecimal yieldNet){
        return valueInvested.add(yieldNet);
    }

}