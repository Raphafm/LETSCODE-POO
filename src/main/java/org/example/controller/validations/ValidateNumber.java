package org.example.controller.validations;

import org.example.model.Cores;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateNumber {

    public static BigDecimal run (Scanner sc) {
            try {
                return sc.nextBigDecimal();
            } catch (InputMismatchException ex) {
                sc.nextLine();
                System.out.println(Cores.RED);
                System.out.println("Não digite letras, por favor");
                System.out.println(Cores.RESET);
                System.out.print("Nova resposta: ");
                return run(sc);
            }
    }

}
