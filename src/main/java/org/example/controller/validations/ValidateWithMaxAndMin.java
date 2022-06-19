package org.example.controller.validations;

import org.example.model.Cores;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateWithMaxAndMin {
    public static BigDecimal run(Scanner sc, BigDecimal min, BigDecimal max) {
        try {
            BigDecimal valor = sc.nextBigDecimal();
            if (valor.compareTo(min) >= 0 && valor.compareTo(max) <= 0) {
                return  valor;
            }

            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.printf("Valor invalido, digite valores entre %s e %s%n", min, max);
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return run(sc, min, max);

        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println(Cores.RED);
            System.out.println("Não digite letras, por favor");
            System.out.println(Cores.RESET);
            System.out.print("Nova resposta: ");
            return run(sc, min, max);
        }
    }
}
