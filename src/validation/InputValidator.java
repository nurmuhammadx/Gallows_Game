package validation;

import java.util.Scanner;

public class InputValidator {

    private  InputValidator() {}

    public static int getValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter an integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
