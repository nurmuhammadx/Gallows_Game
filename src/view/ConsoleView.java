package view;

import service.GameService;
import validation.InputValidator;

import java.util.Scanner;

public class ConsoleView {
    private final int STATES = 5;
    private final Scanner scanner = new Scanner(System.in);
    private final GameService gameService;

    public ConsoleView(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        while (true) {
            System.out.println("\n=== Menu ===");
            for (MenuOption menuOption : MenuOption.values()) {
                    System.out.printf("%d. %s%n", menuOption.getValue(), menuOption.getDescription());
            }
            System.out.print("Enter your choice: ");
            int choice = InputValidator.getValidInt(scanner);
            switch (choice) {
                case 1 -> startGame();
                case 0 -> {
                    System.out.println("Exit...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Incorrect choice, enter 1 or 0!");
            }
        }
    }

    private void startGame() {
        gameService.startNewGame();
        System.out.println("\n=== Game ===");
        while (!gameService.isGameOver()) {
            System.out.println(gameService.getHiddenWord());
            if (gameService.getLives() <= STATES) {
                System.out.println(GallowsGraphics.STAGES.get(STATES - gameService.getLives()));
            }
            System.out.print("Input letters: ");
            gameService.printInputLetters();
            System.out.println("\nYour lives: " + gameService.getLives());
            System.out.print("Enter letter: ");
            char letter = scanner.next().charAt(0);
            gameService.processLetter(letter);
        }
        printResult();
    }

    private void printResult() {
        if (gameService.getLives() == 0) {
            System.out.println(GallowsGraphics.STAGES.get(STATES));
            System.out.println("=== You lose!  ===");
            System.out.println("The hidden word: " + gameService.getTargetWord());
        } else {
            System.out.println("\n=== You win! ===");
            System.out.println("The hidden word: " + gameService.getTargetWord());
        }
    }
}
