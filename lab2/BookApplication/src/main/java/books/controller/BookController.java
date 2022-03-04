package books.controller;

import books.domain.Book;
import books.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String isbn){
        Book book =  bookService.find(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.add(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") String id){
        bookService.update(book,id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") String id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> books =  bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }



}
