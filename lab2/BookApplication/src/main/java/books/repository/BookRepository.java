package books.repository;

import books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private Map<String, Book> mapper = new HashMap<>();

    public Book save(Book book) {
        mapper.put(book.getIsbn(),book);
        return book;
    }

    public Book update(Book book, String isbn) {
        mapper.put(isbn,book);
        return book;
    }

    public void remove(Book book) {
        mapper.remove(book.getIsbn());
    }
    
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(mapper.get(isbn));
    }
    
    public List<Book> findAll() {
        return mapper.values().stream().collect(Collectors.toList());
    }
}

