package webshop.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webshop.product.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
