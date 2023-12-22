package Home;

import Entities.Customer;
import Helpers.checkValid;
import Infrastructure.OrderService;
import Pages.CustomerPage;
import Pages.FruitPage;
import Pages.PaymentPage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            SampleData sampleData = new SampleData();
            sampleData.addData();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                Menus.MainMenu();
                int choices;
                do {
                    System.out.print("Enter your choice: ");
                    choices = Integer.parseInt(scanner.nextLine());
                } while (!checkValid.isValidChoice(1, 4, choices));
                switch (choices) {
                    case 1 :
                        FruitPage fruitPage = new FruitPage();
                        fruitPage.Run();
                        break;
                    case 2 :
                        System.out.print("Enter your name: ");
                        Customer customer = new Customer(scanner.nextLine());
                        OrderService orderService = OrderService.GetInstance();
                        orderService.addOrder(customer);
                        CustomerPage customerPage = new CustomerPage(customer);
                        customerPage.Run();
                        break;
                    case 3:
                        PaymentPage paymentPage = new PaymentPage();
                        paymentPage.Run();
                    case 4: return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");;
        }
    }

}
