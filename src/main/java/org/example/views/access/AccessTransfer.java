package org.example.views.access;

import org.example.controller.validations.ValidateNumber;
import org.example.model.Cores;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccessTransfer {
    public static BigDecimal run(Scanner sc){
        BigDecimal value;
        do {
            System.out.print("Informe o valor: ");
            value = ValidateNumber.run(sc);
            sc.nextLine();
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
