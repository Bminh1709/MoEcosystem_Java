package Infrastructure;

import DataStructures.DoublyLinkedList;
import Entities.Fruit;

public class FruitService {
    private static FruitService instance;
    private DoublyLinkedList<Fruit> fruits;


    private FruitService() {
        if (fruits == null) {
            fruits = new DoublyLinkedList<>();
        }
    }

    public static FruitService GetInstance() {
        if (instance == null) instance = new FruitService();
        return instance;
    }

    public void getFruits() {
        System.out.println("------------------------------------- FRUIT TABLE -------------------------------------");
        System.out.printf("%-3s | %-15s | %-8s | %-10s | %-17s | %-20s\n", "ID", "Name", "Price", "Quantity", "Category", "Origin");

        for (Fruit fruit : fruits) {
            System.out.printf("%-3d | %-15s | %-8.3f | %-10d | %-17s | %-20s\n",
                    fruit.getFruitId(),
                    fruit.getFruitName(),
                    fruit.getPrice(),
                    fruit.getQuantity(),
                    fruit.getCategory().getCategoryName(),
                    fruit.getOrigin());
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public boolean isExist() {
        if (fruits.size() <= 0) return false;
        return true;
    }


    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public void remove(Fruit fruit) {
        fruits.remove(fruit);
    }

    public Fruit getFruit(int id) {
        for(Fruit curFruit : fruits) {
            if (curFruit.getFruitId() == id) {
                return curFruit;
            }
        } throw new IllegalArgumentException("The fruit is not existed");
    }

    public void update(Fruit fruit) {
        for(Fruit curFruit : fruits) {
            if (curFruit.getFruitId() == fruit.getFruitId()) {
                curFruit.setFruitName(fruit.getFruitName());
                curFruit.setCategory(fruit.getCategory());
                curFruit.setPrice(fruit.getPrice());
                curFruit.setQuantity(fruit.getQuantity());
                curFruit.setOrigin(fruit.getOrigin());
            }
        }
    }
}
