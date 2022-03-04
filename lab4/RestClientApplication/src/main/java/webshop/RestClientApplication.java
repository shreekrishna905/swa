package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestOperations;

import java.util.Random;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Autowired
	private RestOperations restTemplate;

	@Override
	public void run(String... args) throws Exception {
		String productUrl = "http://localhost:8080/products";
		String cartUrl = "http://localhost:8081/carts";



		String productNumber = random();
	    //add new product
		restTemplate.postForLocation(productUrl, new Product(productNumber,"This is",90.0));

		// get frank
		Product  product = restTemplate.getForObject(productUrl+"/{id}", Product.class, productNumber);

		System.out.println("----------- Product-----------------------");
		System.out.println(product);
		// Create new Shopping cart

		String shoppingCartNumber = random();
		ShoppingCart shoppingCart = new ShoppingCart(shoppingCartNumber);
		shoppingCart.addToCart(new CartLine(2,product));


		//save shopping cart
		restTemplate.postForLocation(cartUrl, shoppingCart);

		shoppingCart = restTemplate.getForObject(cartUrl+"/{id}", ShoppingCart.class,shoppingCartNumber);
		System.out.println("----------- Shopping Cart-----------------------");
		System.out.println(shoppingCart);
	}

	public String random(){
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}
}
