package org.example.controller.validations;

import org.example.model.TextColors;

import java.util.Scanner;

public class ValidateCPF {
    public static String run(Scanner sc){
        String cpf = sc.nextLine();
        if(cpf.length() != 11){
            System.out.println(TextColors.RED);
            System.out.println("CPF invalido, digite novamente!");
            System.out.println(TextColors.RESET);
            System.out.print("Cpf: ");
            return run(sc);
        }

        if (!cpf.matches("[0-9]+")) {
            System.out.println(TextColors.RED);
            System.out.println("Digite apenas números");
            System.out.println(TextColors.RESET);
            return run(sc);
        }

        return cpf;
    }

}
