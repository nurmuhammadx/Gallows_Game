import service.DictionaryService;
import service.GameService;
import repository.FileDictionaryRepository;
import view.ConsoleView;

public  class Main {
    public static void main(String[] args) {
        FileDictionaryRepository repository = new FileDictionaryRepository("src/resources/russian_nouns.txt");
        DictionaryService dictionaryService = new DictionaryService(repository);
        GameService gameService = new GameService(dictionaryService);
        ConsoleView consoleView = new ConsoleView(gameService);
        consoleView.run();
    }
}
/*
todo: 1) validation & some fix
 */