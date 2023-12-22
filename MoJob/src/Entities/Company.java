package Entities;

import DataStructures.DoublyLinkedList;
import DataStructures.Queue;
import DataStructures.Stack;

public class Company {
    private static int idCount = 1;
    private int companyId;
    private String companyName;
    private boolean state = false;  // True: ready to recruit
                                    // False: full slot
    DoublyLinkedList<Job> jobs;
    public Queue<CV> receivedCV;
    public Queue<CV> sentCV;
    public Stack<CV> storage;
    public DoublyLinkedList<User> linkedUser;

    public Company(String companyName) {
        this.companyId = idCount++;
        this.companyName = companyName;
        receivedCV = new Queue<>();
        sentCV = new Queue<>();
        storage = new Stack<>();
        jobs = new DoublyLinkedList<>();
        linkedUser = new DoublyLinkedList<>();
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public DoublyLinkedList<Job> getJobs() {
        return jobs;
    }

    public void setJob(Job job) {
        this.jobs.add(job);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
