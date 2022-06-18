package org.example.views.menssage;
import org.example.model.Client;
import java.math.BigDecimal;

public class TransferMessage {
    public static void run(Client client, BigDecimal valueOld, BigDecimal valueWithdraw){
        System.out.printf("%-45s %9s%n", "Historico", "Valor");
        System.out.printf("%-45s %9.2f%n", "Valor disponivel anteriormente", valueOld);
        System.out.printf("%-45s %9.2f%n", "Valor transferido", valueWithdraw);
        System.out.printf("%-45s %9.2f%n", "Valor disponível atualizado", client.getFund());
    }

    public static void warningValue(Client client){
        System.err.println("Saldo insuficiente!");
        System.err.printf("Saldo Atual: R$ %.2f%n", client.getFund());
    }
}
