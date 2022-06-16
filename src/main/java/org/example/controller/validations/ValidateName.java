package org.example.controller.validations;

import org.example.model.Cores;

import java.util.Scanner;

public class ValidateName {
    public static String run(Scanner sc) {
        String name = sc.nextLine();
        for (int i = 0; i < name.length(); i++) {
            if (!(Character.isAlphabetic((name.charAt(i))))) {
                System.out.println(Cores.RED);
                System.out.println("O nome nao pode conter números");
                System.out.println(Cores.RESET);
                return run(sc);
            }
        }
        return name;
    }
}
