package webshop;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

    private String shoppingCartNumber;

    private List<CartLine> cartLines;

    public ShoppingCart(){
        this.cartLines = new ArrayList<>();
    }

    public ShoppingCart(String shoppingCartNumber){
        this.cartLines = new ArrayList<>();
        this.shoppingCartNumber = shoppingCartNumber;
    }

    public void addToCart(CartLine cartLine){
        this.cartLines.add(cartLine);
    }

    public String getShoppingCartNumber() {
        return shoppingCartNumber;
    }

    public void setShoppingCartNumber(String shoppingCartNumber) {
        this.shoppingCartNumber = shoppingCartNumber;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartNumber='" + shoppingCartNumber + '\'' +
                ", cartLines=" + cartLines +
                '}';
    }
}
