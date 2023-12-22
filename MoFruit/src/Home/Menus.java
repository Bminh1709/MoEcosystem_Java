package Home;

public class Menus {

    public static void MainMenu() {
        System.out.println("==== Welcome to MoFruit ====");
        System.out.println("1) Manage fruit");
        System.out.println("2) Shopping");
        System.out.println("3) Payment");
        System.out.println("4) End program");
        System.out.println("============================");
    }

    public static void FruitMenu() {
        System.out.println("===== Fruit Management =====");
        System.out.println("1) Display fruit");
        System.out.println("2) Add fruit");
        System.out.println("3) Update fruit");
        System.out.println("4) Delete fruit");
        System.out.println("5) Back");
        System.out.println("============================");
    }

    public static void FruitDetailMenu() {
        System.out.println("====== Fruit Details =======");
        System.out.println("1) Name");
        System.out.println("2) Price");
        System.out.println("3) Quantity");
        System.out.println("4) Category");
        System.out.println("5) Origin");
        System.out.println("6) Back");
        System.out.println("============================");
    }

    public static void CustomerMenu() {
        System.out.println("====== Customer Menu =======");
        System.out.println("1) Add fruit");
        System.out.println("2) Remove fruit");
        System.out.println("3) View Cart");
        System.out.println("4) Back");
        System.out.println("============================");
    }

    public static void OrderMenu() {
        System.out.println("===== Order Management =====");
        System.out.println("1) View orders");
        System.out.println("2) Make a payment");
        System.out.println("3) Back");
        System.out.println("============================");
    }

    public static void PaymentConfirmMenu() {
        System.out.println("=== Payment confirmation ===");
        System.out.println("1) Paid");
        System.out.println("2) Back");
        System.out.println("============================");
    }
}
