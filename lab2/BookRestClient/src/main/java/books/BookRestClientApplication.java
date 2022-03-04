package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookRestClientApplication implements CommandLineRunner {

	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BookRestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/books";

		// add Frank
		restTemplate.postForLocation(serverUrl, new Book("54321","Browns", "Python",
				4563.2));
		// add John
		restTemplate.postForLocation(serverUrl,  new Book("12345","Shree", "Java",
				4563.2));
		// get frank
		Book book= restTemplate.getForObject(serverUrl+"/{id}", Book.class, "54321");
		System.out.println("----------- get Browns Author -----------------------");
		System.out.println(book.getAuthor());
		// get all
		Book[] books= restTemplate.getForObject(serverUrl, Book[].class);
		System.out.println("----------- get all books-----------------------");
		System.out.println(Arrays.toString(books));

		// delete Shree Author
		restTemplate.delete(serverUrl+"/{id}", "12345");

		// update java title to Head First Java
		book.setTitle("Head first Java");
		restTemplate.put(serverUrl+"/{id}", book, book.getIsbn());

		// get all
		books= restTemplate.getForObject(serverUrl, Book[].class);
		System.out.println("----------- get all books-----------------------");
		System.out.println(Arrays.toString(books));
	}

}
