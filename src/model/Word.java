package model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Word {
    private final String targetWord;
    private final Set<Character> guessedLetters = new HashSet<>();

    public Word(String targetWord) {
        this.targetWord = targetWord.toLowerCase();
    }

    public String getTargetWord() {
        return targetWord;
    }

    public boolean guessLetter(char letter) {
        char lowerCaseLetter = Character.toLowerCase(letter);
        if (targetWord.indexOf(lowerCaseLetter) != -1) {
            guessedLetters.add(lowerCaseLetter);
            return true;
        }
        return false;
    }

    public String getHiddenWord() {
        StringBuilder builder = new StringBuilder();
        for (char letter : targetWord.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                builder.append(letter);
            } else  {
                builder.append('*');
            }
        }
        return builder.toString();
    }

    public boolean isFullyGuess() {
        for (char letter : targetWord.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}
