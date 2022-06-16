package org.example.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Client extends User {

    private TypeInvestorProfile typeInvestorProfile;
    private BigDecimal fund;
    private String accountNumber;
    private String extract;

    public Client(String nome, String login, String senha, String cpf, String accountNumber, TypeInvestorProfile typeInvestorProfile) {
        super(nome, login, senha, cpf);
        this.accountNumber = accountNumber;
        this.fund = BigDecimal.ZERO;
        this.typeInvestorProfile = typeInvestorProfile;
        this.extract =String.format("%-20s %-10s %n","Data","Valor (R$)");
    }

    public void withdraw(BigDecimal valorSaque) {
        if (this.fund.compareTo(valorSaque) >= 0) {
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            System.out.printf("%-45s %9s%n", "Historico", "Valor");
            System.out.printf("%-45s %9.2f%n", "Valor disponivel anteriormente", this.fund);
            this.fund = this.fund.subtract(valorSaque);
            System.out.printf("%-45s %9.2f%n", "Valor do saque", valorSaque);
            System.out.printf("%-45s %9.2f%n", "Valor disponível atualizado", this.fund);
            this.extract += String.format("%-20s -%9.2f %n",data,valorSaque);
            return;
        }
        System.err.println("Saldo insuficiente!");
        System.err.printf("Saldo Atual: R$ %.2f%n", this.fund);
    }

    public void deposit(BigDecimal valorDeposito) {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.printf("%-45s %9s%n", "Historico", "Valor");
        System.out.printf("%-45s %9.2f%n", "Valor disponivel anteriormente", this.fund);
        this.fund = this.fund.add(valorDeposito);
        System.out.printf("%-45s %9.2f%n", "Valor do deposito", valorDeposito);
        System.out.printf("%-45s %9.2f%n", "Valor disponível atualizado", this.fund);
        this.extract += String.format("%-20s +%9.2f %n",data,valorDeposito);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TypeInvestorProfile getTypeInvestorProfile() {
        return typeInvestorProfile;
    }

    public String printExtract() {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return "------------------------------------------------------------\n" +
                extract + String.format("------------------------------------------------------------ %n" +
                "%-20s  %9.2f %n",data,this.fund) +
                "------------------------------------------------------------\n";
    }
}
