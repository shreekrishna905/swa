package webshop;

public class CartLine {

    private int quantity;

    private Product product;

    public CartLine(){

    }

    public CartLine(int quantity, Product product){
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartLine{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
