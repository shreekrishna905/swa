package webshop.cart.service;

import org.springframework.stereotype.Service;
import webshop.cart.domain.ShoppingCart;
import webshop.cart.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository){
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCart save(ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart findById(String id) {
        return shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Unable to find shopping cart with id :{}",id)));
    }

}
