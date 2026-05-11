package game;

import entity.Word;

public class GameService {
    DictionaryService dictionaryService;

    public GameService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
//        printStr();
    }




    public void printStr() {
        System.out.println("The hidden word: ");
        Word word = new Word(dictionaryService.getRandomWord());
        word.guess('а');
        System.out.println(word.getHiddenWord());

//        System.out.println(launchGame('а'));
    }
}
