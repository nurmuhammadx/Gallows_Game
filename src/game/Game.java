package game;

import repository.FileDictionaryRepository;

public class Game {
    DictionaryService dictionary;

    public Game(DictionaryService dictionary) {
        this.dictionary = dictionary;
        printStr();
    }

    public void printStr() {
        System.out.println(dictionary.getRandomWord());
    }
}
