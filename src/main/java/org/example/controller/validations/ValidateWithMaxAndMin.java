package org.example.controller.validations;

import org.example.model.Cores;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateWithMaxAndMin<T> {
    public T run(Scanner sc, T min, T max) {
        try {
            Object valor = sc.nextDouble();
            if ((Double)valor >= (Double) min && (Double) valor <= (Double) max) {
                return (T) valor;
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
