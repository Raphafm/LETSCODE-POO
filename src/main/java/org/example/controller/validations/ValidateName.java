package org.example.controller.validations;

import org.example.model.TextColors;

import java.util.Scanner;

public class ValidateName {
    public static String run(Scanner sc) {
        String name = sc.nextLine();
        for (int i = 0; i < name.length(); i++) {
            if (!(Character.isAlphabetic((name.charAt(i))))) {
                System.out.println(TextColors.RED);
                System.out.println("O nome nao pode conter números. Digite novamente");
                System.out.println(TextColors.RESET);
                System.out.print("Nome: ");
                return run(sc);
            }
        }
        return name;
    }
}
