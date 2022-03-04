package webshop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @GetMapping("/stocks/{productNumber}")
    public ResponseEntity<Stock> getProductStock(@PathVariable("productNumber") String productNumber){
        return new ResponseEntity<>(new Stock(productNumber,2234), HttpStatus.OK);
    }

}
