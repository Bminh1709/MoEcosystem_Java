package View;

import Entities.Company;
import Entities.Job;
import Entities.User;
import Services.CompanyService;
import Services.UserService;

public class Data {
    public void AddSampleData() {
        Company company = new Company("NashTech");
        company.setState(true);
        company.setJob(new Job("React dev", 2000, 2, "Good English, Bootstrap, Networking"));
        company.setJob(new Job("Embedded dev", 3000, 5, "Good Japanese, Assembly"));

        Company company2 = new Company("MGM");
        company2.setJob(new Job("Backend Js", 1500, 0, "Good English, Spring, AWS"));
        company2.setJob(new Job("Backend .Net", 3000, 5, ".Net framework, Docker"));

        CompanyService companyService = CompanyService.GetInstance();
        companyService.AddCompany(company);
        companyService.AddCompany(company2);

        User user = new User("Minh cute");
        User user2 = new User("Nam baby");
        User user3 = new User("Trung banh bao");

        UserService userService = UserService.GetInstance();
        userService.AddUser(user);
        userService.AddUser(user2);
        userService.AddUser(user3);

    }
}
