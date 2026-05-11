import game.DictionaryService;
import game.Game;
import repository.FileDictionaryRepository;
import view.ConsoleView;

public  class Main {
    public static void main(String[] args) {
        FileDictionaryRepository repository = new FileDictionaryRepository("src/resources/russian_nouns.txt");
        DictionaryService dictionaryService = new DictionaryService(repository);
        Game newGame = new Game(dictionaryService);
        ConsoleView consoleView = new ConsoleView();
        consoleView.startGame();
    }
}