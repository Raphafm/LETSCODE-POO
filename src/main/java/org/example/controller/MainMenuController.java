package org.example.controller;
import org.example.controller.service.Simulation;
import org.example.model.User;
import org.example.views.access.AccessAccount;
import org.example.views.creation.CreateAccount;
import org.example.views.menus.MainMenu;
import java.util.Objects;
import java.util.Scanner;


public class MainMenuController {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        String option = new MainMenu().printMenu(sc);

        switch (option) {
            case "0":
                MainMenu.exit();
                return;
            case "1":
                User user = AccessAccount.run(sc);
                if (Objects.isNull(user)) {
                    MainMenu.nonExistentUser();
                }else{
                    user.accessMenu(sc,user);
                }
                break;
            case "2":
                CreateAccount.run(sc);
                break;
            case "3":
                Simulation.run(sc);
                break;
            default:
                MainMenu.invalidOption();
                break;
        }
        sc.reset(); // clean scanner
        MainMenuController.run();
    }
}
