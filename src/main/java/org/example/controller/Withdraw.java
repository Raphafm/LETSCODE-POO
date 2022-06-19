package org.example.controller;

import org.example.model.Client;
import org.example.views.menssage.TransferMessage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Withdraw {
    public static void run(BigDecimal valueWithdraw, Client client) {
        if (client.getFund().compareTo(valueWithdraw) >= 0) {
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            BigDecimal valueOld = client.getFund();
            client.setFund(client.getFund().subtract(valueWithdraw));
            client.setExtract(client.getExtract() + String.format("%-20s -%9.2f %n",data,valueWithdraw));
            TransferMessage.run(client,valueOld,valueWithdraw);
            return;
        }
        TransferMessage.warningValue(client);
    }

}
