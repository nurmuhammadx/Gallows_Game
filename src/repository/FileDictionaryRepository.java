package repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileDictionaryRepository {
    private final String filePath;

    public FileDictionaryRepository(String fileName) {
        this.filePath = fileName;
    }

    public List<String> getWords() {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read the dictionary",e);
        }
    }
}
