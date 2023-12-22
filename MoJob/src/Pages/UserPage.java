package Pages;


import DataStructures.Array;
import Entities.CV;
import Entities.Company;
import Entities.User;
import Helpers.checkValid;
import Services.CompanyService;
import View.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPage {
    private final User user;

    public UserPage(User user) {
        this.user = user;
    }

    public void Run() {
        try {
            while (true) {
                CompanyService companyService = CompanyService.GetInstance();
                companyService.UpdateAllResponse();
                Scanner scanner = new Scanner(System.in);
                Menus.UserMenu();
                int choice;
                do {
                    System.out.print("Enter your option: ");
                    choice = scanner.nextInt();
                } while (!checkValid.isValidChoice(1, 5, choice));

                switch (choice) {
                    case 1 -> ViewJobs(companyService, scanner);
                    case 2 -> ViewAppliedCompanies();
                    case 3 -> ViewStorage(scanner);
                    case 4 -> WriteCV(companyService, scanner);
                    case 5 -> {
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

    private void ViewStorage(Scanner scanner) {
        try {
            GetFromInbox();
            if (user.storage.isEmpty()) {
                System.out.println("\u001B[31mWait for companies' response\u001B[0m");
                return;
            }
            System.out.println("There are " + user.storage.size() + " response in the storage");
            Menus.ChoiceOption();
            int choice;
            do {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            } while (!checkValid.isValidChoice(1, 2, choice));
            if (choice == 1) {
                printResponseCV();
            }
        } catch (InputMismatchException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void printResponseCV() {
        CV curCV = user.storage.pop();

        Array<String> arr = new Array<>();
        arr.add(curCV.getMessage());

        if (!user.storage.isEmpty() && user.storage.peek().getUser() == curCV.getUser()) {
            while (curCV.getDate().equals(user.storage.peek().getDate())) {
                arr.add(user.storage.pop().getMessage());

                if (user.storage.isEmpty() || user.storage.peek() == null) {
                    break;
                }
            }
        }

        StringBuilder reversedMessage = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            reversedMessage.append(arr.get(i));
        }
        System.out.println(curCV.showCV(reversedMessage.toString()));
    }

    private void GetFromInbox() {
        while (!user.responseCV.isEmpty()) {
            user.storage.push(user.responseCV.poll());
        }
    }

    private void ViewAppliedCompanies() {
        if (user.appliedCompanies.isEmpty()) {
            System.out.println("\u001B[31mYou haven't applied any companies\u001B[0m");
            return;
        }
        System.out.println("------ APPLIED COMPANY -----");
        System.out.printf("%-2s | %-15s\n", "ID", "Name");

        for (Company company : user.appliedCompanies) {
            System.out.printf("%-2d | %-15s\n", company.getCompanyId(), company.getCompanyName());
        }

        System.out.println("----------------------------");
    }

    private void ViewJobs(CompanyService companyService, Scanner scanner) {
        try {
            companyService.GetCompanies();
            int companyId;
            do {
                System.out.print("Choose a company: ");
                companyId = scanner.nextInt();
            } while (!companyService.IsCompanyExist(companyId));
            Company company = companyService.GetCompany(companyId);
            companyService.showJobs(company);
        } catch (InputMismatchException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void WriteCV(CompanyService companyService, Scanner scanner) {
        try {
            companyService.GetCompanies();
            // Step 1: Choose a company
            int companyId;
            do {
                System.out.print("Choose a company: ");
                companyId = scanner.nextInt();
            } while (!companyService.IsCompanyExist(companyId));

            for (CV cv : user.sentCV) {
                if (cv.getCompany().getCompanyId() == companyId) {
                    System.out.println("\u001B[31mPlease, you have sent CV to this company\u001B[0m");
                    return;
                }
            }
            // Step 2: Choose CV type
            Menus.CVMenu();
            int isUseTemplate;
            do {
                System.out.print("Do you wanna use template: ");
                isUseTemplate = scanner.nextInt();
                scanner.nextLine();
            } while (!checkValid.isValidChoice(1, 2, isUseTemplate));
            Company company = companyService.GetCompany(companyId);
            String message = null;
            switch (isUseTemplate) {
                case 1 ->
                    message = """
                        I am reaching out to express my interest in your company.
                        My skills and experience align well with your requirements,
                        and I believe I would be a valuable addition to your team.""";
                case 2 -> {
                    do {
                        System.out.print("Enter your content: ");
                        message = scanner.nextLine();
                    } while (message == null || message.trim().isEmpty());
                }
            }

            CV curCV = new CV(company, user);
            curCV.generateCVTemplate(message);
            System.out.println();
            System.out.println(curCV.getContent());

            Menus.Confirm();
            int confirmChoice;
            do {
                System.out.print("Are you sure to send this: ");
                confirmChoice = scanner.nextInt();
            } while (!checkValid.isValidChoice(1, 2, confirmChoice));

            if (confirmChoice == 1) {
                if (checkValid.isValidLength(message)) {
                    user.sentCV.offer(curCV);
                } else {
                    String[] arr = checkValid.devidePartsOfMessage(message);
                    for (String curMes : arr) {
                        CV newCV = new CV(company, user);
                        newCV.generateCVTemplate(curMes);
                        user.sentCV.offer(newCV);
                    }
                }
                if (user.appliedCompanies.isEmpty()) {
                    user.appliedCompanies.add(company);
                } else {
                    if (!user.appliedCompanies.contains(company))
                        user.appliedCompanies.add(company);
                }
                System.out.println("\u001B[32mSend CV successfully\u001B[0m");
            }

        } catch (InputMismatchException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }




}
