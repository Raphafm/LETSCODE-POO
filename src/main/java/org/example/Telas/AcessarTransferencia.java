package org.example.Telas;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AcessarTransferencia {
    public static BigDecimal executar(Scanner sc){
        BigDecimal valor = BigDecimal.ZERO;
        do {
            System.out.print("Informe o valor: ");
            try {
                valor = sc.nextBigDecimal();
                sc.nextLine();
            }catch (InputMismatchException ex){
                System.err.println("Valor invalido!");
                executar(sc);
            }
        }while(validarValor(sc, valor));
        return valor;
    }
    public static boolean validarValor(Scanner sc, BigDecimal valor){
        System.err.printf("Você confirma o valor de: R$ %.2f %nS - Sim %nN - Nao%n",valor);
        System.err.print("Resposta: ");
        String confirmacao = sc.nextLine();
        if(confirmacao.equalsIgnoreCase("S") || confirmacao.equalsIgnoreCase("Sim")){
            return false;
        }else if (confirmacao.equalsIgnoreCase("N") || confirmacao.equalsIgnoreCase("Nao")) {
            return true;
        }
        System.out.println("Opção invalida! \nDigite novamente!");
        return validarValor(sc, valor);
    }

}
