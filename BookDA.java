import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookDA {
    private Map<String, Book> bookMap;

    public Map<String, Book> getBookMap() {
        return bookMap;
    }

    public BookDA() {
        bookMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Book.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitData = line.split(",");
                Book book = new Book();
                book.setIsbn(splitData[0].trim());
                book.setTitle(splitData[1].trim());
                book.setAuthorName(splitData[2].trim());
                bookMap.put(book.getIsbn(), book);
            }
        } catch (IOException e) {
            System.err.println("Error reading Book.csv: " + e.getMessage());
        }
    }
}
