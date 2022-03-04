package webshop.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.cart.domain.ShoppingCart;
import webshop.cart.service.ShoppingCartService;

@RestController
@RequestMapping("/carts")
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }


    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.save(shoppingCart);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShoppingCart> getById(@PathVariable("id") String id){
        ShoppingCart shoppingCart = shoppingCartService.findById(id);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

}
