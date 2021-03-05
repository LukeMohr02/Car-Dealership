package dealership.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class TakeUserInput {

    static String takeInput(Scanner scan, String[] specificActions, String[] defaultActions) {
        int defLen = defaultActions.length;
        int specLen = specificActions.length;
        int option = 0;
        int userInput = 0;

        for (int i = 0; i < specLen + defLen; i++) {
            String action;

            if (i < specLen) {
                action = specificActions[i];
            } else {
                action = defaultActions[i - specLen];
            }

            System.out.println(++option + ". " + action);

        }

        boolean retry = true;
        do {

            try {
                userInput = scan.nextInt();

                if (userInput < 1 || userInput > (defLen + specLen)) {
                    throw new InputMismatchException();
                } else {
                    retry = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number 1-" + (defLen + specLen));
                scan.next();
            }

        } while (retry);

        if (userInput <= specLen) {
            return specificActions[userInput - 1];
        } else {
            return defaultActions[(userInput - specLen) - 1];
        }
    }
}