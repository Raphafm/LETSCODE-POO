import java.util.ArrayList;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //quantia sera pega do titulo por switch?
        System.out.print("Insira o juros anual: ");
        double JurosAnual = ler.nextFloat();
        Simulacao investimento = new Simulacao(JurosAnual);
        investimento.relatorio();
    }

}
