package view;

import service.GameService;
import java.util.Scanner;

public class ConsoleView {
    private final GameService gameService;
    Scanner scanner = new Scanner(System.in);

    public ConsoleView(GameService newGame) {
        this.gameService = newGame;
    }

    public void run() {
        while (true) {
            System.out.println("\n=== Menu ===");
            for (MenuOption menuOption : MenuOption.values()) {
                    System.out.printf("%d. %s%n", menuOption.getValue(), menuOption.getDescription());
            }

            System.out.print("Enter your choice: ");
            int choice = getInput();
            switch (choice) {
                case 1 -> startGame();
                case 0 -> {
                    System.out.println("Exit...");
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
            if (gameService.getLives() <= 5) {
                System.out.println(GallowsGraphics.STAGES.get(5 - gameService.getLives()));
            }
            System.out.println("Your lives: " + gameService.getLives());
            System.out.print("Enter letter: ");
            char letter = scanner.nextLine().charAt(0);
            gameService.processLetter(letter);
        }
        printResult();
    }

    private void printResult() {
        if (gameService.getLives() == 0) {
            System.out.println(GallowsGraphics.STAGES.get(5));
            System.out.println("=== You lose!  ===");
            System.out.println("The hidden word: " + gameService.getTargetWord());
        } else {
            System.out.println("\n=== You win! ===");
            System.out.println("The hidden word: " + gameService.getTargetWord());
        }
    }

    private int getInput() {
        return Integer.parseInt(scanner.nextLine());
    }

}
