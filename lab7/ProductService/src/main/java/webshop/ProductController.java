package webshop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("{productNumber}")
    public ResponseEntity<Product> getProduct(@PathVariable("productNumber") String productNumber){
        Product product = productService.getStockNumber(productNumber);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
