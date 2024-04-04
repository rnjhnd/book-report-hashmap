import java.util.*;

public class BookReport {
    public static void main(String[] args) {
        BookDA bookDA = new BookDA();
        Map<String, Book> bookMap = bookDA.getBookMap();
        AuthorDA authorDA = new AuthorDA();
        Map<String, Author> authorMap = authorDA.getAuthorMap();

        for (Book book : bookMap.values()) {
            String isbn = book.getIsbn();
            String title = book.getTitle();
            String authorName = book.getAuthorName();
            Author author = authorMap.getOrDefault(authorName, new Author());
            String authorBio = author.getBio();

            System.out.println(isbn + " " + title);
            System.out.println("\t" + authorName + " - " + authorBio);
            System.out.println();
        }
    }
}
