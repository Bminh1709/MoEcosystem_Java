package Services;

import DataStructures.Array;
import Entities.CV;
import Entities.Company;
import Entities.Job;
import Entities.User;

public class CompanyService {
    private static CompanyService instance;
    private Array<Company> companies;

    private CompanyService() {
        if (companies == null) {
            companies = new Array<>();
        }
    }

    public static CompanyService GetInstance() {
        if (instance == null) instance = new CompanyService();
        return instance;
    }

    public void AddCompany(Company company) {
        companies.add(company);
    }

    public void GetCompanies() {
        System.out.println("------- COMPANY TABLE ------");
        System.out.printf("%-2s | %-15s\n", "ID", "Name");

        for (Company company : companies) {
            System.out.printf("%-2d | %-15s\n", company.getCompanyId(), company.getCompanyName());
        }

        System.out.println("----------------------------");
    }

    public boolean IsCompanyExist(int id) {
        int left = 0;
        int right = companies.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentId = companies.get(mid).getCompanyId();

            if (currentId == id) {
                return true;
            } else if (currentId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public Company GetCompany(int id) {
        int left = 0;
        int right = companies.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentId = companies.get(mid).getCompanyId();

            if (currentId == id) {
                return companies.get(mid);
            } else if (currentId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public void showJobs(Company company) {
        if (company.isState()) {
            int count = 1;
            System.out.println("---------------------------------------- JOB TABLE --------------------------------------");
            System.out.printf("%-2s | %-15s | %-10s | %-13s | %-30s\n",
                    "ID", "Title", "Salary", "Experience", "Description");

            for (Job job : company.getJobs()) {
                System.out.printf("%-2d | %-15s | %-10.2f | %-13d | %-30s\n",
                        count++, job.getTitle(), job.getSalary(), job.getExperience(), job.getDescription());
            }

            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Company: " + company.getCompanyName());
            System.out.println("-----------------------------------------------------------------------------------------");
        } else {
            System.out.println("-------------------- Announcement --------------------");
            System.out.println("Company: " + company.getCompanyName());
            System.out.println("Content: \u001B[31mFull of slots, wait for the next recruitment\u001B[0m");
            System.out.println("------------------------------------------------------");
        }
    }

    public void UpdateAllResponse() {
        for (Company company : companies) {
            while (company.sentCV.size() != 0) {
                CV curCV = company.sentCV.poll();
                User desUser = curCV.getUser();
                desUser.responseCV.offer(curCV);
            }
        }
    }
}
