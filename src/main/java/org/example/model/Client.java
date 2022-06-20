package org.example.model;

import org.example.controller.ClientMenuController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client extends User {

    private TypeInvestorProfile typeInvestorProfile;
    private BigDecimal fund;
    private String accountNumber;
    private String extract;

    public Client(String name, String login, String password, String cpf, String accountNumber, TypeInvestorProfile typeInvestorProfile) {
        super(name, login, password, cpf);
        this.accountNumber = accountNumber;
        this.fund = BigDecimal.ZERO;
        this.typeInvestorProfile = typeInvestorProfile;
        this.extract =String.format("%-20s %-10s %n","Data","Valor (R$)");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TypeInvestorProfile getTypeInvestorProfile() {
        return typeInvestorProfile;
    }

    public String toString() {
        return String.format("%-30s %-15s %-20.2f %-30s %-20s\n", name, super.id,
                fund, typeInvestorProfile.getLabel(), accountNumber);
    }

    public String toStringExtract() {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return "------------------------------------------------------------\n" +
                extract + String.format("------------------------------------------------------------ %n" +
                "%-20s  %9.2f %n",data,this.fund) +
                "------------------------------------------------------------\n";
    }

    public BigDecimal getFund() {
        return fund;
    }

    public String getExtract() {
        return extract;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    @Override
    public void accessMenu(Scanner sc) {
        ClientMenuController.runClientMenu(sc, this);
    }
}
