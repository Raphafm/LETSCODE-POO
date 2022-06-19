package org.example.views.show;
import org.example.model.Investment;

import java.math.BigDecimal;

public class ShowYields {

    public static void run(Investment investment, BigDecimal yield, BigDecimal priceIof, BigDecimal priceADM, BigDecimal priceIR,
                           BigDecimal priceTotalYieldNet, BigDecimal priceTotalYield){

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%d dias rendendo\n", investment.getTimeInvested());
        System.out.printf("Relatório de investimento para R$ %.2f investidos, a uma taxa de juros anual de %.2f %%.\n",
                investment.getValueInvested(), investment.getProduct().getAnnualProfitability()*100.);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-30s %-20s %-20s%n", "Rendimento (R$)", "Tributos (R$)", "IOF (R$)",
                "Taxa Administrativa (R$)", "Valor Bruto (R$)", "Valor Líquido (R$)");
        System.out.printf("%-20.2f %-20.2f %-20.2f %-30.2f %-20.2f %-20.2f%n", yield, priceIR, priceIof, priceADM,
                priceTotalYield, priceTotalYieldNet);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
