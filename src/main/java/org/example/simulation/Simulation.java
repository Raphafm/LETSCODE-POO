package org.example.simulation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    static Scanner sc = new Scanner(System.in);
    //static int opcao;
    double jurosDiarios;
    double jurosAnual;
    BigDecimal quantiaInvestida;
    //inicalizacao
    ArrayList<BigDecimal> rendimentos = new ArrayList<>();
    ArrayList<BigDecimal> tributacao= new ArrayList<>();
    ArrayList<BigDecimal> ganhoLiquido= new ArrayList<>();
    ArrayList<BigDecimal> valoresFinais= new ArrayList<>();
    ArrayList<BigDecimal> iof= new ArrayList<>();
    ArrayList<Double>  tempoDeInvestimento= new ArrayList<>();
    //Cria Objeto
    public Simulation(double jurosAnual){
        this.quantiaInvestida = getQuantiaInvestida();
        this.tempoDeInvestimento=tempoDeInvestimento();
        this.jurosAnual = jurosAnual;
        this.jurosDiarios=getjurosDiarios(jurosAnual);
        this.rendimentos = rendimentos(quantiaInvestida,jurosDiarios,tempoDeInvestimento);
        this.iof = iof(rendimentos,tempoDeInvestimento);
        this.tributacao = gettributacao(rendimentos,tempoDeInvestimento,iof);
        this.ganhoLiquido = getRendimentosLiquidos(tributacao,rendimentos,iof);
        this.valoresFinais = getvaloresFinais(quantiaInvestida,ganhoLiquido);
    }
    //Quantia investida
    public BigDecimal getQuantiaInvestida() {
        System.out.print("Insira a Quantia a ser investida: ");
        quantiaInvestida = sc.nextBigDecimal();
        return quantiaInvestida;
    }
    //Tempo de investimento
    public static ArrayList<Double>  tempoDeInvestimento(){
        ArrayList<Double> tempoDeInvestimento = new ArrayList<>();

            System.out.println("Insira o(s) tempo(s) pelo qual quer ver o rendimento (insira o tempo em dias)\nDigite -1 para encerrar a inserção:");
            double tempo;
            while (true) {
                tempo = sc.nextDouble();
                if (tempo == -1){
                    break;
                }
                tempoDeInvestimento.add(tempo);
            }
        /*
        Coloquei essa parte antes para opções pré definidas de tempo, mas acho que não faz sentido, é melhor deixar a encargo do usuário quanto tempo ele quer

        System.out.print("Deseja inserir o tempo pelo qual vai deixar o investimento?\nDigite 1 para SIM ou digite 2 para NÃO\n");
        opcao = sc.nextInt();
        if (opcao==1) {
        }else{
            //em dias
            tempoDeInvestimento.add(50d);
            tempoDeInvestimento.add(100d);
            tempoDeInvestimento.add(365d);
            tempoDeInvestimento.add(730d);
            tempoDeInvestimento.add(1825d);
        }*/
        return tempoDeInvestimento;
    }
    //Transformação do juros anual em juros diario
    public double getjurosDiarios(double jurosAnual){
        jurosDiarios = Math.pow((1.0d+jurosAnual),1.0d/365.0d)-1.0d;
        return jurosDiarios;
    }
    //Calculo do rendimento de acordo com o investimento
    public ArrayList<BigDecimal> rendimentos(BigDecimal quantiaInvestida, double jurosDiarios, ArrayList<Double> tempoDeInvestimento) {
        for (Double periodo : tempoDeInvestimento) {
            rendimentos.add(BigDecimal.valueOf(Math.pow((1 + jurosDiarios), periodo)).multiply(quantiaInvestida).subtract(quantiaInvestida));
        }
        return rendimentos;
    }
    //Funcao IOF
    public ArrayList<BigDecimal> iof(ArrayList<BigDecimal> rendimentos,  ArrayList<Double> tempoDeInvestimento) {
        for (int i=0;i<tempoDeInvestimento.size();i++){
            BigDecimal txIof;
            if (tempoDeInvestimento.get(i)<30){
                txIof= BigDecimal.valueOf((2880d-96d*tempoDeInvestimento.get(i))/2900d);
            }else{
                txIof= BigDecimal.valueOf(0);
            }
            iof.add(rendimentos.get(i).multiply(txIof));
        }
        return iof;
    }
    //Funcao IR
    public ArrayList<BigDecimal> gettributacao(ArrayList<BigDecimal> rendimentos,  ArrayList<Double> tempoDeInvestimento,ArrayList<BigDecimal> iof) {
        BigDecimal Txtributacao;
        for (int i = 0; i < tempoDeInvestimento.size(); i++) {
            if (180 > tempoDeInvestimento.get(i)) {
                Txtributacao = BigDecimal.valueOf(0.225);
            } else if (tempoDeInvestimento.get(i) < 360 || tempoDeInvestimento.get(i) == 360) {
                Txtributacao = BigDecimal.valueOf(0.20);
            } else {
                if (tempoDeInvestimento.get(i) < 720 || tempoDeInvestimento.get(i) == 720) {
                    Txtributacao = BigDecimal.valueOf(0.175);
                } else {
                    Txtributacao = BigDecimal.valueOf(0.15);
                }
            }
            tributacao.add(Txtributacao.multiply(rendimentos.get(i).subtract(iof.get(i))));
        }
        return tributacao;
    }
    //Calculo Liquido, em função do IR e do IOF
    public ArrayList<BigDecimal> getRendimentosLiquidos(ArrayList<BigDecimal> tributacao,ArrayList<BigDecimal> rendimentos,ArrayList<BigDecimal> iof) {
        for(int i=0; i<rendimentos.size();i++){
            ganhoLiquido.add((rendimentos.get(i).subtract(tributacao.get(i)).subtract(iof.get(i))));
        }
        return ganhoLiquido;
    }
    //Valores Finais
    public ArrayList<BigDecimal> getvaloresFinais(BigDecimal quantiaInvestida,ArrayList<BigDecimal> ganhoLiquido){
        for (BigDecimal ganhos : ganhoLiquido) {
            valoresFinais.add(quantiaInvestida.add(ganhos));
        }
        return valoresFinais;
    }
    //relatorio
    public void relatorio(){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("Relatório de investimento para %.2fR$ investidos, a uma taxa de juros anual de %.2f porcento.\n",
                this.quantiaInvestida,this.jurosAnual*100);
        for (int i=0; i<this.tempoDeInvestimento.size();i++){
            System.out.printf("%d - %.0f dias\n",i+1,this.tempoDeInvestimento.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i=0; i<this.tempoDeInvestimento.size();i++){
            System.out.printf("%d - Rendimento: %.2fR$, Tributos: %.2fR$, IOF: %.2fR$, Rendimentos Líquidos: %.2fR$, Valor Final: " +
                            "%.2fR$\n",i+1,this.rendimentos.get(i),
                    this.tributacao.get(i),this.iof.get(i),this.ganhoLiquido.get(i),this.valoresFinais.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
