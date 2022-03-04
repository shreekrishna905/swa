package webshop;

public class Product {

    private String productNumber;

    private String name;

    private int stock;

    public Product(){}

    public Product(String productNumber,String name, int stock){
        this.productNumber = productNumber;
        this.name = name;
        this.stock = stock;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
