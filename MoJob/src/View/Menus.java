package View;

public class Menus {
    public static void MainMenu() {
        System.out.println("===== Welcome to MoJob =====");
        System.out.println("1) Login as Developer");
        System.out.println("2) Login as Employer");
        System.out.println("3) End program");
        System.out.println("============================");
    }

    public static void UserMenu() {
        System.out.println("======= Welcome back =======");
        System.out.println("1) View companies");
        System.out.println("2) View applied companies");
        System.out.println("3) View storage");
        System.out.println("4) Submit CV");
        System.out.println("5) Logout");
        System.out.println("============================");
    }

    public static void CVMenu() {
        System.out.println("======== CV Options ========");
        System.out.println("1) Use Template");
        System.out.println("2) Custom");
        System.out.println("============================");
    }

    public static void Confirm() {
        System.out.println("======= Confirmation =======");
        System.out.println("1) Confirm");
        System.out.println("2) Discard");
        System.out.println("============================");
    }

    public static void ChoiceOption() {
        System.out.println("========== Action ==========");
        System.out.println("1) View");
        System.out.println("2) Back");
        System.out.println("============================");
    }

    public static void EmployerMenu() {
        System.out.println("======= Welcome back =======");
        System.out.println("1) View CV");
        System.out.println("2) View Applicants");
        System.out.println("3) Logout");
        System.out.println("============================");
    }
}
