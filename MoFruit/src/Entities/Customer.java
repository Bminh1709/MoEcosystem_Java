package Entities;


import DataStructures.Stack;

public class Customer {
    private static int countId = 1;
    private int customerId;
    private String customerName;
    private double totalAmount;
    private Stack<Detail> details;

    public Customer(String customerName) {
        this.customerId = countId++;
        this.customerName = customerName;
        details = new Stack<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addToCart(Detail detail) {
        totalAmount += detail.getFruit().getPrice() * detail.getQuantity();
        details.push(detail);
    }

    public Detail removeItemInCart() {
        if (details.isEmpty()) throw new IllegalArgumentException("Your cart is empty");
        Detail detail = details.pop();
        totalAmount -= detail.getFruit().getPrice() * detail.getQuantity();
        return detail;
    }

    public void displayCart() {
        if (details.isEmpty()) throw new IllegalArgumentException("Your cart is empty");
        int count = 1;

        System.out.println("------------------------------ Cart Table -----------------------------");
        System.out.printf("|%-5s|%-17s|%-10s|%-18s|%-15s|\n", "ID", "Name", "Quantity", "Price per Unit", "Total Price");

        for (Detail detail : details) {
            Fruit fruit = detail.getFruit();
            int quantity = detail.getQuantity();
            double totalPrice = detail.getQuantity() * fruit.getPrice();

            System.out.printf("|%-5d|%-17s|%-10d|%-18.2f|%-15.3f|\n",
                    count++,
                    fruit.getFruitName(),
                    quantity,
                    fruit.getPrice(),
                    totalPrice);
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("|%-6s%-13s\n", "Name:", this.customerName);
        System.out.printf("|%-14s%-15.3f\n", "Total Amount:", this.totalAmount);
        System.out.println("-----------------------------------------------------------------------");

    }



}
