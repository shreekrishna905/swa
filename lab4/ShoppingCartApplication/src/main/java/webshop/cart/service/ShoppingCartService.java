package webshop.cart.service;

import webshop.cart.domain.ShoppingCart;

public interface ShoppingCartService {
     ShoppingCart save(ShoppingCart shoppingCart);
     ShoppingCart findById(String id);
}
