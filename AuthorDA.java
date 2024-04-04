import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AuthorDA {
    private Map<String, Author> authorMap;

    public Map<String, Author> getAuthorMap() {
        return authorMap;
    }

    public AuthorDA() {
        authorMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Author.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] authorSplitData = line.split(",");
                Author author = new Author();
                author.setName(authorSplitData[0].trim());
                author.setBio(authorSplitData[1].trim());
                authorMap.put(author.getName(), author);
            }
        } catch (IOException e) {
            System.err.println("Error reading Author.csv: " + e.getMessage());
            // You can also throw a custom exception or take other actions
        }
    }
}

