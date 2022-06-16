package org.example.controller.validations;

import org.example.model.Cores;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateNumber<T> {

    public T run (Scanner sc) {
            try {
                Object valor = sc.nextDouble();
                return (T) valor;
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
