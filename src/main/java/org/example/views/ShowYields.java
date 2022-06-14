package org.example.views;

import org.example.model.Investiment;

import java.math.BigDecimal;

public class ShowYields {

    public static void relatorio(Investiment investiment, BigDecimal yield, BigDecimal priceIof, BigDecimal priceIR,
                                 BigDecimal priceTotalYieldNet, BigDecimal priceTotalYield){

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%d dias simulados\n",investiment.getTempoDeInvestimento());
        System.out.printf("Relatório de investimento para R$ %.2f investidos, a uma taxa de juros anual de %.2f %%.\n",
                investiment.getQuantiaInvestida(),investiment.getProduct().getRentabilidadeAnual()*100.);

        System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("Rendimento: R$ %.2f // Tributos: R$ %.2f // IOF: R$ %.2f // Valor Bruto: R$ %.2f // " +
                    "Valor Líquido: R$ %.2f\n",yield,priceIR,priceIof,priceTotalYield, priceTotalYieldNet);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
