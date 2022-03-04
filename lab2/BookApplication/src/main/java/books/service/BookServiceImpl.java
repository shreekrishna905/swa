package books.service;

import books.domain.Book;
import books.integration.JmsSender;
import books.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private JmsSender jmsSender;

    public BookServiceImpl(BookRepository bookRepository, JmsSender jmsSender){
        this.bookRepository = bookRepository;
        this.jmsSender = jmsSender;
    }

    @Override
    public Book add(Book book) {
        bookRepository.save(book);
        jmsSender.sendMessage(book);
        return book;
    }

    @Override
    public Book update(Book book, String isbn) {
        Book mayBeBook = bookRepository.findById(isbn).orElseThrow(() -> new RuntimeException("Book isbn:"+isbn+" not found"));
        mayBeBook.setAuthor(book.getAuthor());
        mayBeBook.setIsbn(isbn);
        mayBeBook.setTitle(book.getTitle());
        mayBeBook.setPrice(book.getPrice());
        Book updatedBook = bookRepository.update(mayBeBook,isbn);
        jmsSender.sendMessage(updatedBook);
        return updatedBook;
    }

    @Override
    public void delete(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(() -> new RuntimeException("Book isbn:"+isbn+" not found"));
        bookRepository.remove(book);
        jmsSender.sendMessage(book);
    }

    @Override
    public Book find(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(() -> new RuntimeException("Book isbn:"+isbn+" not found"));
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
