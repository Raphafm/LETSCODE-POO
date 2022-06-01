package org.example.Telas;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AcessTransfer {
    public static BigDecimal run(Scanner sc){
        BigDecimal value = BigDecimal.ZERO;
        do {
            System.out.print("Informe o value: ");
            try {
                value = sc.nextBigDecimal();
                sc.nextLine();
            }catch (InputMismatchException ex){
                System.err.println("Valor invalido!");
                run(sc);
            }
        }while(validateValue(sc, value));
        return value;
    }

    public static boolean validateValue(Scanner sc, BigDecimal valor){
        System.err.printf("Você confirma o valor de: R$ %.2f %nS - Sim %nN - Nao%n",valor);
        System.err.print("Resposta: ");
        String confirmacao = sc.nextLine();
        if(confirmacao.equalsIgnoreCase("S") || confirmacao.equalsIgnoreCase("Sim")){
            return false;
        }else if (confirmacao.equalsIgnoreCase("N") || confirmacao.equalsIgnoreCase("Nao")) {
            return true;
        }
        System.err.println("Opção invalida! \nDigite novamente!");
        return validateValue(sc, valor);
    }
}
