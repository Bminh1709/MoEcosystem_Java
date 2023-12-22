package Entities;

import DataStructures.DoublyLinkedList;
import DataStructures.Queue;
import DataStructures.Stack;

public class User {
    private static int idCount = 1;
    private int userId;
    private String userName;
    private String expertise;
    public Queue<CV> sentCV;
    public Queue<CV> responseCV;
    public Stack<CV> storage;
    public DoublyLinkedList<Company> appliedCompanies;

    public User(String userName) {
        this.userId = idCount++;
        this.userName = userName;
        sentCV = new Queue<>();
        responseCV = new Queue<>();
        storage = new Stack<>();
        appliedCompanies = new DoublyLinkedList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
