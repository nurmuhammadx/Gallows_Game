package service;

import repository.FileDictionaryRepository;

import java.util.List;
import java.util.Random;

public class DictionaryService {
    private final List<String> words;
    private final Random random = new Random();

    public DictionaryService(FileDictionaryRepository repository) {
        this.words = repository.getWords();
    }

    public String getRandomWord() {
        if (words.isEmpty()) return null;
        return words.get(random.nextInt(words.size()));
    }
}
