package service;

import model.Word;

public class GameService {
    private int lives;
    private boolean isWin;
    private Word newWord;
    private final DictionaryService dictionaryService;

    public GameService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public void startNewGame() {
        newWord = new Word(dictionaryService.getRandomWord());
        lives = 6;
        isWin = false;
    }

    public void processLetter(char letter) {
        if (!newWord.guessLetter(letter)) {
            lives--;
        }
        isWin = newWord.isFullyGuess();
    }

    public boolean isGameOver() {
        return lives == 0 || isWin;
    }

    public int getLives() {
        return lives;
    }

    public String getHiddenWord() {
        return newWord.getHiddenWord();
    }

    public String getTargetWord() {
        return newWord.getTargetWord();
    }
}
