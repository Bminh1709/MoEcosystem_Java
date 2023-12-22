package Pages;

import DataStructures.Array;
import Entities.CV;
import Entities.Company;
import Entities.User;
import Helpers.CVStatus;
import Helpers.checkValid;
import Services.CompanyService;
import Services.UserService;
import View.Menus;

import java.util.*;

public class EmployerPage {
    private Company company;
    private CompanyService companyService;

    public EmployerPage(CompanyService companyService, Company company) {
        this.companyService = companyService;
        this.company = company;
    }

    public void Run() {
        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                UserService userService = UserService.GetInstance();
                userService.UpdateALLCVs();
                Menus.EmployerMenu();
                int choice;
                do {
                    System.out.print("Enter your option: ");
                    choice = scanner.nextInt();
                } while (!checkValid.isValidChoice(1, 4, choice));
                switch (choice) {
                    case 1 -> ViewCV(scanner);
                    case 2 -> ViewApplicants();
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


    private void ViewApplicants() {
        if (company.linkedUser.isEmpty()) {
            System.out.println("\u001B[31mThere is no applied applicants\u001B[0m");
            return;
        }
        System.out.println("---------- STORAGE ---------");
        System.out.printf("%-2s | %-15s\n", "ID", "Name");

        for (User user : company.linkedUser) {
            System.out.printf("%-2d | %-20s\n", user.getUserId(), user.getUserName());
        }

        System.out.println("----------------------------");
    }

    private void ViewCV(Scanner scanner) {
        try {
            GetFromInbox();
            if (company.storage.isEmpty()) {
                System.out.println("\u001B[31mThere is no applied CVs\u001B[0m");
                return;
            }
            System.out.println("There are " + company.storage.size() + " response in the storage");
            Menus.ChoiceOption();
            int choice;
            do {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            } while (!checkValid.isValidChoice(1, 2, choice));
            if (choice == 1) {
                Array<CV> CVs = printCV();

                Menus.Confirm();
                int confirmChoice;
                do {
                    System.out.print("Does this applicant fit your company: ");
                    confirmChoice = scanner.nextInt();
                } while (!checkValid.isValidChoice(1, 2, confirmChoice));

                switch (confirmChoice) {
                    case 1 -> CVs.get(CVs.size() - 1).setStatus(CVStatus.Accept);
                    case 2 -> CVs.get(CVs.size() - 1).setStatus(CVStatus.Decline);
                }

                for(CV cv : CVs) {
                    company.sentCV.offer(cv);
                }
                User user = CVs.get(0).getUser();
                if (company.linkedUser.isEmpty()) {
                    company.linkedUser.add(user);
                } else {
                    if (!company.linkedUser.contains(user))
                        company.linkedUser.add(user);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\u001B[31mPlease, enter a valid number\u001B[0m");
        } catch (Exception e) {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
        }
    }

    private Array<CV> printCV() {
        CV curCV = company.storage.pop();

        Array<CV> arr = new Array<>();
        arr.add(curCV);

        if (!company.storage.isEmpty() && company.storage.peek().getUser() == curCV.getUser()) {
            while (curCV.getDate().equals(company.storage.peek().getDate())) {
                arr.add(company.storage.pop());

                if (company.storage.isEmpty() || company.storage.peek() == null) {
                    break;
                }
            }
        }

        StringBuilder reversedMessage = new StringBuilder();
        for (int i = arr.size() - 1; i >= 0; i--) {
            reversedMessage.append(arr.get(i).getMessage());
        }
        System.out.println(curCV.showCV(reversedMessage.toString()));

        return arr;
    }
    private void GetFromInbox() {
        while (!company.receivedCV.isEmpty()) {
            company.storage.push(company.receivedCV.poll());
        }
    }
}
