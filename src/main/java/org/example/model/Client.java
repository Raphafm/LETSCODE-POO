package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}
