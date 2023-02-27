package model;

public class Product {
    private String label;
    private int price;
    private int stock;

    public String getLabel() {
        return label;
    }

    public Product(String label, int price, int stock) {
        this.label = label;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
