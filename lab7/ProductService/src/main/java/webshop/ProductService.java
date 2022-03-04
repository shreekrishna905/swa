package webshop;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("stock-service")
public interface ProductService {

    @GetMapping("/stocks/{productNumber}")
    Product getStockNumber(@PathVariable("productNumber") String
                                   productNumber);
}
