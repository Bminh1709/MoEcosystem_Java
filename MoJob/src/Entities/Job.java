package Entities;

public class Job {
    private String title;
    private double salary;
    private int experience;
    private String description;

    public Job(String title, double salary, int experience, String description) {
        this.title = title;
        this.salary = salary;
        this.experience = experience;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
