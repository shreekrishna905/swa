package webshop.product.service;

import webshop.product.domain.Product;

public interface ProductService {
    Product save(Product product);

    Product findById(String id);
}
