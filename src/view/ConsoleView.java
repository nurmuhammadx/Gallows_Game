package view;

import service.GameService;
import java.util.Scanner;

public class ConsoleView {
    private final GameService gameService;
    Scanner scanner = new Scanner(System.in);

    public ConsoleView(GameService newGame) {
        this.gameService = newGame;
    }

    public void runConsoleView() {
        while (true) {
            System.out.println("\n=== Menu ===");
            for (MenuOption menuOption : MenuOption.values()) {
                    System.out.printf("%d. %s%n", menuOption.getValue(), menuOption.getDescription());
            }

            System.out.print("Enter your choice: ");
            int choice = getInput();
            switch (choice) {
                case 1 -> start();
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

    private void start() {
        gameService.startNewGame();
        System.out.println("\n=== Game ===");
        System.out.println(gameService.getHiddenWord());
        while (!gameService.isGameOver()) {
            System.out.println("Your lives: " + gameService.getLives());
            System.out.print("Enter letter: ");
            char letter = scanner.nextLine().charAt(0);
            gameService.processLetter(letter);
        }
        System.out.println(gameService.getLives() == 0 ? "You lose!" : "You win!");
        runConsoleView();
    }

}
