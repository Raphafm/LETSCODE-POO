import java.util.ArrayList;
import java.util.Scanner;

public class Simulacao {
    static Scanner ler = new Scanner(System.in);
    static int opcao;
    double jurosDiarios;
    double jurosAnual;
    double quantiaInvestida;
    //inicalizacao
    ArrayList<Double> rendimentos = new ArrayList<>();
    ArrayList<Double> tributacao = new ArrayList<Double>();
    ArrayList<Double> ganhoLiquido = new ArrayList<Double>();
    ArrayList<Double> valoresFinais = new ArrayList<Double>();
    ArrayList<Double> iof = new ArrayList<Double>();
    ArrayList<Double>  tempoDeInvestimento = new ArrayList<Double>();
    //Cria Objeto
    public Simulacao(double jurosAnual){
        this.quantiaInvestida = getQuantiaInvestida();
        this.tempoDeInvestimento=tempoDeInvestimento();
        this.jurosAnual = jurosAnual;
        this.jurosDiarios=getjurosDiarios(jurosAnual);
        this.rendimentos = rendimentos(quantiaInvestida,jurosDiarios,tempoDeInvestimento);
        this.iof = iof(rendimentos,tempoDeInvestimento);
        this.tributacao = gettributacao(rendimentos,tempoDeInvestimento,iof,quantiaInvestida);
        this.ganhoLiquido = getRendimentosLiquidos(tributacao,rendimentos,iof);
        this.valoresFinais = getvaloresFinais(quantiaInvestida,ganhoLiquido);
    }
    //Quantia investida
    public double getQuantiaInvestida() {
        System.out.print("Insira a Quantia a ser investida: ");
        quantiaInvestida = ler.nextDouble();
        return quantiaInvestida;
    }
    //Tempo de investimento
    public static ArrayList<Double>  tempoDeInvestimento(){
        ArrayList<Double> tempoDeInvestimento = new ArrayList<Double>();
        System.out.print("Deseja inserir o tempo pelo qual vai deixar o investimento?\nDigite 1 para SIM ou digite 2 para NÃO\n");
        opcao = ler.nextInt();
        if (opcao==1) {
            System.out.println("Insira o(s) tempo(s) pelo qual quer ver o rendimento (insira o tempo em dias)\nDigite -1 para encerrar a inserção:");
            double tempo;
            while (true) {
                tempo = ler.nextDouble();
                if (tempo == -1){
                    break;
                }
                tempoDeInvestimento.add(tempo);
            }
        }else{
            //em dias
            tempoDeInvestimento.add(50d);
            tempoDeInvestimento.add(100d);
            tempoDeInvestimento.add(365d);
            tempoDeInvestimento.add(730d);
            tempoDeInvestimento.add(1825d);
        }
        return tempoDeInvestimento;
    }
    //Transformação do juros anual em juros diario
    public double getjurosDiarios(double jurosAnual){
        jurosDiarios = Math.pow((1.0d+jurosAnual/100.0d),1.0d/365.0d)-1.0d;
        return jurosDiarios;
    }
    //Calculo do rendimento de acordo com o investimento
    public ArrayList<Double> rendimentos(double quantiaInvestida, double jurosDiarios,  ArrayList<Double> tempoDeInvestimento) {
        for(int i = 0; i< tempoDeInvestimento.size(); i++){
            rendimentos.add(Math.pow((1+jurosDiarios),tempoDeInvestimento.get(i))*quantiaInvestida-quantiaInvestida);
        }
        return rendimentos;
    }
    //Funcao IOF
    public ArrayList<Double> iof(ArrayList<Double> rendimentos,  ArrayList<Double> tempoDeInvestimento) {
        for (int i=0;i<tempoDeInvestimento.size();i++){
            double txIof = 0;
            if (tempoDeInvestimento.get(i)<30){
                txIof=(2880d-96d*tempoDeInvestimento.get(i))/2900d;
            }else{
                txIof=0;
            }
            iof.add(txIof*rendimentos.get(i));
        }
        return iof;
    }
    //Funcao IR
    public ArrayList<Double> gettributacao(ArrayList<Double> rendimentos,  ArrayList<Double> tempoDeInvestimento,ArrayList<Double> iof,double quantiaInvestida) {
            double Txtributacao;
            for (int i = 0; i < tempoDeInvestimento.size(); i++) {
                if (180 > tempoDeInvestimento.get(i)) {
                    Txtributacao = 22.5;
                } else if (tempoDeInvestimento.get(i) < 360 || tempoDeInvestimento.get(i) == 360) {
                    Txtributacao = 20;
                } else {
                    if (tempoDeInvestimento.get(i) < 720 || tempoDeInvestimento.get(i) == 720) {
                        Txtributacao = 17.5;
                    } else {
                        Txtributacao = 15;
                    }
                }
                tributacao.add(Txtributacao * (rendimentos.get(i) - iof.get(i)) / 100);
            }
        return tributacao;
    }
    //Calculo Liquido, em função do IR e do IOF
    public ArrayList<Double> getRendimentosLiquidos(ArrayList<Double> tributacao,ArrayList<Double> rendimentos,ArrayList<Double> iof) {
        for(int i=0; i<rendimentos.size();i++){
            ganhoLiquido.add((rendimentos.get(i)-tributacao.get(i)-iof.get(i)));
        }
        return ganhoLiquido;
    }
    //Valores Finais
    public ArrayList<Double> getvaloresFinais(double quantiaInvestida,ArrayList<Double> ganhoLiquido){
        for(int i=0; i<ganhoLiquido.size();i++) {
            valoresFinais.add(quantiaInvestida + ganhoLiquido.get(i));
        }
        return valoresFinais;
    }
    //relatorio
    public void relatorio(){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("Relatório de investimento para %.2fR$ investidos, a uma taxa de juros anual de %.2f porcento.\n",
                this.quantiaInvestida,this.jurosAnual);
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
    /*    public void relatorio(List<Double> tempoDeInvestimento,double quantiaInvestida,ArrayList<Double> rendimentos,
               ArrayList<Double>tributacao,ArrayList<Double>ganhoLiquido,ArrayList<Double>valoresFinais){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("Relatório de investimento para %.2f R$ investidos\n",quantiaInvestida);
        for (int i=0; i<tempoDeInvestimento.size();i++){
            System.out.printf("%d - %.0f dias\n",i+1,tempoDeInvestimento.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i=0; i<tempoDeInvestimento.size();i++){
            System.out.printf("%d - Rendimento: %.2fR$, Tributos: %.2fR$, rendimentos Líquidos: %.2fR$, Valor Final: " +
                            "%.2fR$\n",i+1,rendimentos.get(i),
                    tributacao.get(i),ganhoLiquido.get(i),valoresFinais.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }*/
}
