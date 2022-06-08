package org.example.model;
import org.example.quiz.TypeInvestorProfile;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Client extends User {

    private TypeInvestorProfile tipoPerfilInvestidor;
    private BigDecimal valorDisponivel;
    private String numeroConta;
    private String extrato;


//    private final ArrayList<Inventimentos> inventimentos;

    public Client(String nome, String login, String senha, String cpf, String numeroConta, TypeInvestorProfile tipoPerfilInvestidor) {
        super(nome, login, senha, cpf);
        this.numeroConta = numeroConta;
        this.valorDisponivel = BigDecimal.ZERO;
        this.tipoPerfilInvestidor = tipoPerfilInvestidor;
        this.extrato =String.format("%-20s %-10s %n","Data","Valor (R$)");

//        this.inventimentos = new ArrayList<Inventimentos>();
//        public BigDecimal resgatar(){
//            return BigDecimal.ZERO;
//        }
    }

    public void withdraw(BigDecimal valorSaque) {
        if (this.valorDisponivel.compareTo(valorSaque) >= 0) {
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            System.out.printf("%-45s %9s%n", "Historico", "Valor");
            System.out.printf("%-45s %9.2f%n", "Valor disponivel anteriormente", this.valorDisponivel);
            this.valorDisponivel = this.valorDisponivel.subtract(valorSaque);
            System.out.printf("%-45s %9.2f%n", "Valor do saque", valorSaque);
            System.out.printf("%-45s %9.2f%n", "Valor disponível atualizado", this.valorDisponivel);
            this.extrato += String.format("%-20s -%9.2f %n",data,valorSaque);
            return;
        }
        System.err.println("Saldo insuficiente!");
        System.err.printf("Saldo Atual: R$ %.2f%n", this.valorDisponivel);
    }

    public void deposit(BigDecimal valorDeposito) {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.printf("%-45s %9s%n", "Historico", "Valor");
        System.out.printf("%-45s %9.2f%n", "Valor disponivel anteriormente", this.valorDisponivel);
        this.valorDisponivel = this.valorDisponivel.add(valorDeposito);
        System.out.printf("%-45s %9.2f%n", "Valor do deposito", valorDeposito);
        System.out.printf("%-45s %9.2f%n", "Valor disponível atualizado", this.valorDisponivel);
        this.extrato += String.format("%-20s +%9.2f %n",data,valorDeposito);
    }



    //    public Tipoinvestidor getTipoinvestidor() {
//        return tipoinvestidor;
//    }
//
//    public void setTipoinvestidor(Tipoinvestidor tipoinvestidor) {
//        this.tipoinvestidor = tipoinvestidor;
//    }
//
//    public ArrayList<Inventimentos> getInventimentos() {
//        return inventimentos;
//    }


    public String printExtract() {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return "------------------------------------------------------------\n" +
                extrato + String.format("------------------------------------------------------------ %n" +
                "%-20s  %9.2f %n",data,this.valorDisponivel) +
                "------------------------------------------------------------\n";
    }
}
