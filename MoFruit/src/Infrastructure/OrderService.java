package Infrastructure;

import DataStructures.Queue;
import Entities.Customer;

public class OrderService {
    private static OrderService instance;

    private Queue<Customer> orders;

    private OrderService() {
        if (orders == null) {
            this.orders = new Queue<>();
        }
    }

    public static OrderService GetInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void addOrder(Customer customer) {
        orders.offer(customer);
    }

    public Customer peek() {
        return orders.peek();
    }

    public void displayOrders() {
        if (orders.isEmpty()) throw new IllegalArgumentException("There is no orders");
        int count = 1;
        System.out.println("------------ Order Table ------------");
        System.out.printf("|%-3s|%-15s|%-15s|\n", "No", "Customer Name", "Total Amount");

        for (Customer customer : orders) {
            System.out.printf("|%-3d|%-15s|%-15.3f|\n",
                    count++,
                    customer.getCustomerName(),
                    customer.getTotalAmount());
        }

        System.out.println("-------------------------------------");
    }

    public void paidOrder() {
        if (orders.isEmpty()) throw new IllegalArgumentException("There is no orders");
        orders.poll();
    }
}
