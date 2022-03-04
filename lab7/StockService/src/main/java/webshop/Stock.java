package webshop;

public class Stock {

    private String productNumber;

    private int stock;

    public Stock(){}

    public Stock(String productNumber, int stock){
        this.productNumber = productNumber;
        this.stock = stock;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
