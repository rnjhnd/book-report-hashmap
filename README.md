# Book Report Hashmap Generator

A Java implementation that demonstrates **HashMap data structure** usage for efficient book and author data management. This project creates comprehensive book reports by combining book information with author biographies using ISBN as the primary key.

## 📋 Overview

The Book Report Hashmap Generator efficiently processes book and author data from CSV files to generate detailed reports. Using HashMap data structures with ISBN as keys, the system provides fast lookup capabilities while maintaining clean separation between data access and business logic through the Data Access (DA) pattern.

## 🏗️ Architecture

This project implements a **Data Access Pattern** with HashMap-based data management:

- **Book Class**: Represents book entities with ISBN, title, and author name
- **Author Class**: Represents author entities with name and biography
- **BookDA Class**: Data Access layer for book data using HashMap with ISBN as key
- **AuthorDA Class**: Data Access layer for author data using HashMap with name as key
- **BookReport Class**: Main application that generates comprehensive book reports

### Design Benefits

- **Performance**: O(1) average time complexity for book lookups using HashMap
- **Efficiency**: Fast data retrieval and processing
- **Maintainability**: Clean separation between data access and business logic
- **Scalability**: Easy to extend with additional book and author attributes

## 📊 UML Class Diagram
<img width="772" height="217" alt="UML Class Diagram" src="https://github.com/user-attachments/assets/dc6c7d72-2af0-4768-9872-929fe7aee802" />

The following diagram illustrates:
- The relationship between Book and Author entities
- How ISBN serves as the primary key for book identification
- The data flow from CSV files to HashMap structures
- The integration between book and author information

## 🚀 Features

- **HashMap Data Structure**: Efficient O(1) lookup using ISBN as keys
- **CSV File Processing**: Automated data loading from Book.csv and Author.csv
- **Data Access Pattern**: Clean separation of data access logic
- **Comprehensive Reports**: Detailed book information with author biographies
- **Error Handling**: Robust file reading with exception management
- **Memory Efficient**: Optimized data storage and retrieval

## 📁 Project Structure

```
book-report-hashmap/
├── src/
│   ├── Book.java                     # Book entity class
│   ├── Author.java                   # Author entity class
│   ├── BookDA.java                   # Book Data Access layer
│   ├── AuthorDA.java                 # Author Data Access layer
│   └── BookReport.java               # Main application
├── data/                             # Data files directory
│   ├── Book.csv                      # Book information data
│   └── Author.csv                    # Author information data
└── README.md                         # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Getting Started

1. **Clone or download** the project files
2. **Navigate** to the project directory
3. **Ensure CSV files** are in the correct location (project root or data folder)
4. **Compile** the Java files:
   ```bash
   javac src/*.java
   ```
5. **Run** the application:
   ```bash
   java -cp src BookReport
   ```

## 📖 Usage

### Data Files

**Book.csv** - Contains book information:
```
Isbn, title, author name
BK-1234,The Lord of the Rings,J.R.R. Tolkien
BK-5678,The Hobbit,J.R.R. Tolkien
BK-9012,Pride and Prejudice,Jane Austen
BK-2345,Sense and Sensibility,Jane Austen
BK-7890,To Kill a Mockingbird,Harper Lee
BK-3456,One Hundred Years of Solitude,Gabriel Garcia Marquez
BK-0987,Love in the Time of Cholera,Gabriel Garcia Marquez
```

**Author.csv** - Contains author information:
```
name,bio
J.R.R. Tolkien,English philologist and university professor
Jane Austen,English novelist known for her wit
Harper Lee,American novelist best known for her Pulitzer Prize-winning novel.
Douglas Adams,English science fiction writer and documentary filmmaker. 
F. Scott Fitzgerald,American novelist and short-story writer.
Gabriel Garcia Marquez,Colombian novelist known for his magical realism works.
```

### Expected Output

When you run the application, you'll see:

```
BK-1234 The Lord of the Rings
	J.R.R. Tolkien - English philologist and university professor

BK-5678 The Hobbit
	J.R.R. Tolkien - English philologist and university professor

BK-9012 Pride and Prejudice
	Jane Austen - English novelist known for her wit

BK-2345 Sense and Sensibility
	Jane Austen - English novelist known for her wit

BK-7890 To Kill a Mockingbird
	Harper Lee - American novelist best known for her Pulitzer Prize-winning novel.

BK-3456 One Hundred Years of Solitude
	Gabriel Garcia Marquez - Colombian novelist known for his magical realism works.

BK-0987 Love in the Time of Cholera
	Gabriel Garcia Marquez - Colombian novelist known for his magical realism works.
```

## 🔧 Implementation Details

### HashMap Usage

The project demonstrates effective HashMap implementation:

```java
// Book HashMap with ISBN as key
Map<String, Book> bookMap = new HashMap<>();
bookMap.put(book.getIsbn(), book);

// Author HashMap with name as key
Map<String, Author> authorMap = new HashMap<>();
authorMap.put(author.getName(), author);
```

### Data Access Pattern

Clean separation of concerns through DA classes:

```java
// Book Data Access
BookDA bookDA = new BookDA();
Map<String, Book> bookMap = bookDA.getBookMap();

// Author Data Access
AuthorDA authorDA = new AuthorDA();
Map<String, Author> authorMap = authorDA.getAuthorMap();
```

### File Processing

Robust CSV file reading with error handling:

```java
try (BufferedReader reader = new BufferedReader(new FileReader("Book.csv"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        String[] splitData = line.split(",");
        // Process data and populate HashMap
    }
} catch (IOException e) {
    System.err.println("Error reading Book.csv: " + e.getMessage());
}
```

## 🎯 Design Patterns Used

### Data Access Pattern
- **Purpose**: Separate data access logic from business logic
- **Benefits**: Maintainable, testable, and reusable code
- **Implementation**: `BookDA` and `AuthorDA` classes handle all data operations

### HashMap Pattern
- **Purpose**: Efficient data storage and retrieval using key-value pairs
- **Benefits**: O(1) average time complexity for lookups
- **Implementation**: ISBN as key for books, author name as key for authors

## 📊 Sequence Diagram
<img width="1474" height="763" alt="Sequence Diagram" src="https://github.com/user-attachments/assets/9aac8e6f-7d7b-46c1-bbc4-3ed950f7508f" />

The sequence diagram illustrates:
- The flow of data from CSV files to HashMap structures
- How BookReport coordinates between BookDA and AuthorDA
- The process of generating comprehensive book reports
- Error handling and data validation steps

## 🔧 Extending the Project

### Adding New Book Attributes

To add new book attributes (e.g., publication year, genre):

1. **Update** the `Book` class with new fields and methods
2. **Modify** `BookDA` to parse additional CSV columns
3. **Update** `BookReport` to display new information

### Adding New Author Attributes

To add new author attributes (e.g., nationality, birth year):

1. **Update** the `Author` class with new fields and methods
2. **Modify** `AuthorDA` to parse additional CSV columns
3. **Update** `BookReport` to display new information

### Database Integration

To extend with database support:

1. **Create** database connection classes
2. **Modify** DA classes to use database queries instead of CSV files
3. **Maintain** the same HashMap interface for consistency

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new book and author attributes
- Implementing database integration
- Adding unit tests
- Improving error handling
- Enhancing the report formatting

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates effective use of HashMap data structures for efficient data management and retrieval. The Data Access pattern ensures clean separation of concerns, making the code maintainable and extensible for future enhancements.
