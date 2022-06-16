package org.example.controller.validations;

import org.example.model.Cores;

import java.util.Scanner;

public class ValidateCPF {
    public static String run(Scanner sc){
        String cpf = sc.nextLine();
        if(cpf.length() != 11){
            System.out.println(Cores.RED);
            System.out.println("CPF invalido, digite novamente!");
            System.out.println(Cores.RESET);
            return run(sc);
        }

        if (!cpf.matches("[0-9]+")) {
            return run(sc);
        }
        System.out.println(Cores.RED);
        System.out.println("Digite apenas números");
        System.out.println(Cores.RESET);

        return cpf;
    }

}
