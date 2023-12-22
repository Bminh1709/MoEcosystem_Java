package Pages;

import Entities.Category;
import Entities.Fruit;
import Helpers.checkValid;
import Home.Menus;
import Infrastructure.CategoryService;
import Infrastructure.FruitService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class FruitPage {

    public void Run() {
        try {
            while (true) {
                Menus.FruitMenu();
                Scanner scanner = new Scanner(System.in);

                FruitService fruitService = FruitService.GetInstance();

                int choice;
                do {
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                } while (!checkValid.isValidChoice(1, 5, choice));

                switch (choice) {
                    case 1 : displayFruits(fruitService);
                        break;
                    case 2 : addFruit(fruitService, scanner);
                        break;
                    case 3 : updateFruit(fruitService, scanner);
                        break;
                    case 4 : deleteFruit(fruitService, scanner);
                        break;
                    case 5 : return;
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please, enter the valid number");
        }
    }

    private void deleteFruit(FruitService fruitService, Scanner scanner) {
        try {
            System.out.print("Enter fruit id: ");
            int fruitId = scanner.nextInt();
            Fruit fruit = fruitService.getFruit(fruitId);
            fruitService.remove(fruit);
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void updateFruit(FruitService fruitService, Scanner scanner) {
        try {
            if (fruitService.isExist()) {
                System.out.print("Enter fruit id: ");
                int fruitId = scanner.nextInt();
                scanner.nextLine();
                Fruit fruit = fruitService.getFruit(fruitId);
                while (true) {
                    Menus.FruitDetailMenu();
                    int choice;
                    do {
                        System.out.print("Enter your choice: ");
                        choice = Integer.parseInt(scanner.nextLine());
                    } while (!checkValid.isValidChoice(1, 6, choice));
                    switch (choice) {
                        case 1:
                            System.out.print("Enter name: ");
                            fruit.setFruitName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Enter price: ");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            fruit.setPrice(price);
                            break;
                        case 3:
                            System.out.print("Enter quantity: ");
                            int quanity = scanner.nextInt();
                            scanner.nextLine();
                            fruit.setQuantity(quanity);
                            break;
                        case 4:
                            CategoryService categoryService = CategoryService.GetInstance();
                            categoryService.getCategories();
                            System.out.print("Enter category id: ");
                            int categoryId = scanner.nextInt();
                            scanner.nextLine();
                            Category category = categoryService.getCategory(categoryId);
                            fruit.setCategory(category);
                            break;
                        case 5:
                            System.out.print("Enter origin: ");
                            fruit.setOrigin(scanner.nextLine());
                            break;
                        case 6:
                            return;
                    }
                }
            } else System.out.println("There is no fruit!");
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void addFruit(FruitService fruitService, Scanner scanner) {
        try {
            CategoryService categoryService = CategoryService.GetInstance();
            Fruit newFruit = new Fruit();
            System.out.println("===== Enter fruit info =====");
            System.out.print("Name: ");
            newFruit.setFruitName(scanner.nextLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            newFruit.setPrice(price);
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            newFruit.setQuantity(quantity);
            categoryService.getCategories();
            System.out.print("Category: ");
            int categoryId = Integer.parseInt(scanner.nextLine());
            newFruit.setCategory(categoryService.getCategory(categoryId));
            System.out.print("Origin: ");
            newFruit.setOrigin(scanner.nextLine());
            newFruit.setFruitId();
            fruitService.addFruit(newFruit);
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }

    }

    private void displayFruits(FruitService fruitService) {
        fruitService.getFruits();
    }


}
