package Pages;

import Entities.Customer;
import Helpers.checkValid;
import Home.Menus;
import Infrastructure.FruitService;
import Infrastructure.OrderService;

import java.util.Scanner;

public class PaymentPage {

    public void Run() {
        try {
            while (true) {
                OrderService orderService = OrderService.GetInstance();
                Menus.OrderMenu();
                Scanner scanner = new Scanner(System.in);

                int choice;
                do {
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                } while (!checkValid.isValidChoice(1, 3, choice));

                switch (choice) {
                    case 1 : ViewOrders(orderService);
                        break;
                    case 2 : MakePayment(orderService, scanner);
                        break;
                    case 3 : return;
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please, enter the valid number");
        }
    }

    private void MakePayment(OrderService orderService, Scanner scanner) {
        try {
            System.out.println("=> Payment confirmation: ");
            Customer customer = orderService.peek();
            customer.displayCart();
            Menus.PaymentConfirmMenu();
            int choice;
            do {
                System.out.print("The bill has been paid? ");
                choice = scanner.nextInt();
            } while (!checkValid.isValidChoice(1, 2, choice));
            while (true) {
                switch (choice) {
                    case 1: orderService.paidOrder();
                        return;
                    case 2: return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void ViewOrders(OrderService orderService) {
        try {
            orderService.displayOrders();
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }
}
