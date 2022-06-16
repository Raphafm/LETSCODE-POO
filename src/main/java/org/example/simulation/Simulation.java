package org.example.simulation;
import org.example.model.Investiment;
import org.example.views.ShowYields;
import org.example.views.creation.CreateInvestiment;
import org.example.views.creation.CreateSimulation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    public void runSimulation(Scanner sc) {
        resumeCalculo(CreateSimulation.printSimulation(sc));
        sc.nextLine();
    }

    public void runInvestiment(List<Investiment> listInvestimento) {
        for (int i = 0; i < listInvestimento.size(); i++) {
            System.out.printf("%d - %s %s  %n",i+1,listInvestimento.get(i).getDiaDoInvenstimento(),
                    listInvestimento.get(i).getProduct().getNome());
            resumeCalculo(listInvestimento.get(i));
        }
    }

    public void resumeCalculo(Investiment investiment) {
        BigDecimal dailyFees = anualFeesToDailyFees(investiment.getProduct().getRentabilidadeAnual());
        BigDecimal yield = yields(investiment.getQuantiaInvestida(),dailyFees, investiment.getTempoDeInvestimento());
        BigDecimal priceIof = valueIof(yield, investiment.getTempoDeInvestimento());
        BigDecimal priceIR = valueIR(yield, investiment.getTempoDeInvestimento(), priceIof);
        BigDecimal priceYieldNet = yieldNet(priceIR,yield,priceIof);
        BigDecimal priceTotalYieldNet = totalYieldNet(investiment.getQuantiaInvestida(),priceYieldNet);
        investiment.setGanhoLiquido(priceTotalYieldNet);
        BigDecimal priceTotalYield = totalYield(investiment.getQuantiaInvestida(),yield);
        ShowYields.relatorio(investiment, yield, priceIof, priceIR, priceTotalYieldNet, priceTotalYield);
    }

    private BigDecimal anualFeesToDailyFees(double anualFees){
        return BigDecimal.valueOf(Math.pow((1.0d+anualFees),1.0d/252.0d)-1.0d);
    }

    // rendimento bruto
    private BigDecimal yields(BigDecimal valueInvested, BigDecimal dailyFees, int timeInvestedDays) {
        return  BigDecimal.ONE.add(dailyFees).pow(timeInvestedDays).multiply(valueInvested).subtract(valueInvested);
    }

    //Funcao IOF
    private BigDecimal valueIof(BigDecimal yield, int timeInvestedDays) {
        BigDecimal txIof = timeInvestedDays<30? BigDecimal.valueOf((2880d-96d*timeInvestedDays)/2900d) : BigDecimal.ZERO;
        return yield.multiply(txIof);
    }

    //Funcao valueIR
    private BigDecimal valueIR(BigDecimal yield, int timeInvestedDays, BigDecimal priceIof) {
        BigDecimal Txtributacao = BigDecimal.ONE;
        for (int i = 0; i < EnumFees.values().length; i++) {
            if (EnumFees.values()[i].getTimeDays() >= timeInvestedDays) {
                Txtributacao = BigDecimal.valueOf(EnumFees.values()[i].getFees());
                break;
            }
        }
        return Txtributacao.multiply(yield.subtract(priceIof));
    }

    //Calculo Liquido, em função do valueIR e do IOF
    private BigDecimal yieldNet(BigDecimal priceIR, BigDecimal yield, BigDecimal priceIof) {
        return yield.subtract(priceIR).subtract(priceIof);
    }

    private BigDecimal totalYield(BigDecimal valueInvested,BigDecimal yield){
        return valueInvested.add(yield);
    }

    //Valores Finais
    private BigDecimal totalYieldNet(BigDecimal valueInvested,BigDecimal yieldNet){
        return valueInvested.add(yieldNet);
    }

}