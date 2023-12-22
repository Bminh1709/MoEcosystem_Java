package Helpers;

import Entities.Fruit;

public class checkValid {
    public static boolean isValidChoice(int start, int end, int choice) {
        if (choice >= start && choice <= end) return true;
        return false;
    }

    public static boolean isValidQuantity(int quantity, Fruit fruit) {
        if (quantity > 0 && quantity <= fruit.getQuantity()) return true;
        System.out.println("\u001B[31mInvalid number!\u001B[0m");
        return false;
    }
}
