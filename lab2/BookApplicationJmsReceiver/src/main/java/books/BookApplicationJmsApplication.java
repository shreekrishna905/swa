package books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class BookApplicationJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplicationJmsApplication.class, args);
	}

}
