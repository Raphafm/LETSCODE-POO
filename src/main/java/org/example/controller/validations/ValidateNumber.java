package org.example.controller.validations;

import org.example.model.TextColors;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateNumber {

    public static BigDecimal run (Scanner sc) {
            try {
                return sc.nextBigDecimal();
            } catch (InputMismatchException ex) {
                sc.nextLine();
                System.out.println(TextColors.RED);
                System.out.println("Não digite letras, por favor");
                System.out.println(TextColors.RESET);
                System.out.print("Nova resposta: ");
                return run(sc);
            }
    }

}
