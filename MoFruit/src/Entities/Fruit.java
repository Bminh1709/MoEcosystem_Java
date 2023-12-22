package Entities;

public class Fruit {
    private static int idCount = 1;
    private int fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private Category category;
    private String origin;

    public Fruit(String fruitName, double price, int quantity, Category category, String origin) {
        this.fruitId = idCount++;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.origin = origin;
    }

    public Fruit() {
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId() {
        this.fruitId = idCount++;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        if (fruitName.isBlank()) throw new IllegalArgumentException("Fruit name cannot be empty");
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be bigger than zero");
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Number of products must be bigger than zero");
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        if (origin.isBlank()) throw new IllegalArgumentException("Origin cannot be empty");
        this.origin = origin;
    }
}
