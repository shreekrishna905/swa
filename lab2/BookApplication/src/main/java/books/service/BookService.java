package books.service;

import books.domain.Book;

import java.util.List;

public interface BookService {

    Book add(Book book);

    Book update(Book book, String isbn);

    void delete(String isbn);

    Book find(String isbn);

    List<Book> findAll();

}
