package org.example.views;
import org.example.model.Cores;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AcessTransfer {
    public static BigDecimal run(Scanner sc){
        BigDecimal value = BigDecimal.ZERO;
        do {
            System.out.print("Informe o valor: ");
            try {
                value = sc.nextBigDecimal();
                sc.nextLine();
            }catch (InputMismatchException ex){
                System.out.println("Valor invalido!");
                run(sc);
            }
        }while(validateValue(sc, value));
        return value;
    }

    private static boolean validateValue(Scanner sc, BigDecimal value){
        System.out.println(Cores.RED);
        System.out.printf("Você confirma o value de: R$ %.2f %nS - Sim %nN - Nao%n", value);
        System.out.println(Cores.RESET);
        System.out.print("Resposta: ");
        String verification = sc.nextLine();
        if(verification.equalsIgnoreCase("S") || verification.equalsIgnoreCase("Sim")){
            return false;
        }else if (verification.equalsIgnoreCase("N") || verification.equalsIgnoreCase("Nao")) {
            return true;
        }
        System.out.println(Cores.RED);
        System.out.println("Opção inválida, digite novamente");
        System.out.println(Cores.RESET);
        return validateValue(sc, value);
    }
}
