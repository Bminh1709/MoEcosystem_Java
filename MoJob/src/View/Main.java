package View;

import Helpers.checkValid;
import Pages.EmployerPage;
import Pages.UserPage;
import Services.CompanyService;
import Services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Data data = new Data();
            data.AddSampleData();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                Menus.MainMenu();
                int choice;
                do {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                } while (!checkValid.isValidChoice(1, 3, choice));
                switch (choice) {
                    case 1 -> {
                        UserService userService = UserService.GetInstance();
                        userService.GetUsers();
                        int userId;
                        do {
                            System.out.print("Enter your id: ");
                            userId = scanner.nextInt();
                        } while (!userService.IsUserExist(userId));
                        UserPage userPage = new UserPage(userService.GetUser(userId));
                        userPage.Run();
                    }
                    case 2 -> {
                        CompanyService companyService = CompanyService.GetInstance();
                        companyService.GetCompanies();
                        int companyId;
                        do {
                            System.out.print("Enter your id: ");
                            companyId = scanner.nextInt();
                        } while (!companyService.IsCompanyExist(companyId));
                        EmployerPage employerPage = new EmployerPage(companyService, companyService.GetCompany(companyId));
                        employerPage.Run();
                    }
                    case 3 -> {
                        return;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }
}
