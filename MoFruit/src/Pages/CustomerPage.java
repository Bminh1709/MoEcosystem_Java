package Pages;

import Entities.Customer;
import Entities.Detail;
import Entities.Fruit;
import Helpers.checkValid;
import Home.Menus;
import Infrastructure.FruitService;

import java.util.Scanner;

public class CustomerPage {

    private Customer customer;

    public CustomerPage(Customer customer) {
        this.customer = customer;
    }

    public void Run() {
        try {
            while (true) {
                FruitService fruitService = FruitService.GetInstance();
                Menus.CustomerMenu();
                Scanner scanner = new Scanner(System.in);
                int choice;
                do {
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                } while (!checkValid.isValidChoice(1, 5, choice));

                switch (choice) {
                    case 1 :
                        addFruitToCart(fruitService, scanner);
                        break;
                    case 2 :
                        removeFruitInCart(fruitService);
                        break;
                    case 3 :
                        viewCart();
                        break;
                    case 4 : return;
                }
            }
        }  catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void viewCart() {
        try {
            customer.displayCart();
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }


    private void removeFruitInCart(FruitService fruitService) {
        try {
            Detail removedDetail = customer.removeItemInCart();
            Fruit fruit = fruitService.getFruit(removedDetail.getFruit().getFruitId());
            fruit.setQuantity(fruit.getQuantity() + removedDetail.getQuantity());
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void addFruitToCart(FruitService fruitService, Scanner scanner) {
        try {
            fruitService.getFruits();
            System.out.print("Enter fruit id: ");
            int fruitId = scanner.nextInt();
            Fruit fruit = fruitService.getFruit(fruitId);
            int quantity;
            do {
                System.out.print("Enter quantity: ");
                quantity = scanner.nextInt();
            } while (!checkValid.isValidQuantity(quantity, fruit));
            fruit.setQuantity(fruit.getQuantity() - quantity);
            customer.addToCart(new Detail(fruit, quantity));
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }
}
