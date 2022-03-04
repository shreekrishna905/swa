package webshop.product.service;

import org.springframework.stereotype.Service;
import webshop.product.domain.Product;
import webshop.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(String id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product with id:"+ id +" not found"));
    }
}
