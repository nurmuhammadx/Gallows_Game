package view;

import game.Game;

import java.util.Scanner;

public class ConsoleView {
    Scanner scanner = new Scanner(System.in);
    MenuOption menuOption;

    public void startGame() {
        while (true) {
            System.out.println("\n=== Menu ===");
            for (MenuOption menuOption : MenuOption.values()) {
                    System.out.printf("%d. %s%n", menuOption.getValue(), menuOption.getDescription());
            }

            int choice = getInput();
            switch (choice) {
                case 1 -> new Game(); // will be soon!
                case 0 -> {
                    System.out.println("Exit...");
                    return;
                }
                default -> System.out.println("Incorrect choice, enter 1 or 0!");
            }
        }
    }

    private int getInput() {
        return Integer.parseInt(scanner.nextLine());
    }

}
