package org.example.views.show;
import org.example.model.Investment;

import java.math.BigDecimal;

public class ShowYields {

    public static void report(Investment investment, BigDecimal yield, BigDecimal priceIof, BigDecimal priceADM, BigDecimal priceIR,
                              BigDecimal priceTotalYieldNet, BigDecimal priceTotalYield){

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%d dias rendendo\n", investment.getTimeInvested());
        System.out.printf("Relatório de investimento para R$ %.2f investidos, a uma taxa de juros anual de %.2f %%.\n",
                investment.getValueInvested(), investment.getProduct().getAnnualProfitability()*100.);

        System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("Rendimento: R$ %.2f // Tributos: R$ %.2f // IOF: R$ %.2f // Taxa Administrativa: R$ %.2f // Valor Bruto: R$ %.2f // " +
                    "Valor Líquido: R$ %.2f\n",yield,priceIR,priceIof,priceADM,priceTotalYield, priceTotalYieldNet);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
