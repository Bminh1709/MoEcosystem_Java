package Services;

import DataStructures.Array;
import Entities.CV;
import Entities.Company;
import Entities.User;

public class UserService {
    private static UserService instance;
    private Array<User> users;

    private UserService() {
        if (users == null) {
            users = new Array<>();
        }
    }

    public static UserService GetInstance() {
        if (instance == null) instance = new UserService();
        return instance;
    }

    public void AddUser(User user) {
        users.add(user);
    }

    public void GetUsers() {
        System.out.println("-------- USER TABLE --------");
        System.out.printf("%-2s | %-15s\n", "ID", "Name");

        for (User user : users) {
            System.out.printf("%-2d | %-20s\n", user.getUserId(), user.getUserName());
        }

        System.out.println("----------------------------");
    }

    public boolean IsUserExist(int id) {
        int left = 0;
        int right = users.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentId = users.get(mid).getUserId();

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

    public User GetUser(int id) {
        int left = 0;
        int right = users.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentId = users.get(mid).getUserId();

            if (currentId == id) {
                return users.get(mid);
            } else if (currentId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public void UpdateALLCVs() {
        for (User user : users) {
            while (user.sentCV.size() != 0) {
                CV curCV = user.sentCV.poll();
                Company company = curCV.getCompany();
                company.receivedCV.offer(curCV);
            }
        }
    }
}
