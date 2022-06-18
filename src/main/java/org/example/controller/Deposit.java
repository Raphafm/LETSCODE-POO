package org.example.controller;

import org.example.model.Client;
import org.example.views.menssage.TransferMessage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deposit {
    public static void run(BigDecimal valueDeposit, Client client) {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        BigDecimal valueOld = client.getFund();
        client.setFund(client.getFund().add(valueDeposit));
        client.setExtract(client.getExtract() + String.format("%-20s +%9.2f %n",data, valueDeposit));
        TransferMessage.run(client,valueOld,valueDeposit);
    }
}
