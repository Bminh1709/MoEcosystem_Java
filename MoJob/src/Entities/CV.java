package Entities;

import Helpers.CVStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CV {
    private Company company;
    private User user;
    private Date date;
    private String content;
    private String message;
    private CVStatus status = CVStatus.Processing;

    public Company getCompany() {
        return company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CVStatus getStatus() {
        return status;
    }

    public void setStatus(CVStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CV(Company company, User user) {
        this.date = new Date();
        this.company = company;
        this.user = user;
    }

    public String getContent() {
        StringBuilder template = new StringBuilder();
        template.append(content);
        if (this.status != CVStatus.Processing) {
            template.append("Status: ").append(this.status).append("\n");
            template.append("------------------------------------------------------------").append("\n");
        }
        content = template.toString();
        return content;
    }

    public void generateCVTemplate(String customMessage) {
        StringBuilder template = new StringBuilder();
        template.append("------------------------ CV CONTENT ------------------------").append("\n");
        this.message = customMessage;

        template.append("Dear ").append(company.getCompanyName()).append(",\n")
                .append(this.message).append("\n")
                .append("Best regards,\n")
                .append(user.getUserName()).append("\n")
                .append("Date: ").append(getFormattedDate()).append("\n");

        template.append("------------------------------------------------------------").append("\n");

        content = template.toString();
    }

    public String showCV(String message) {
        System.out.println();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder template = new StringBuilder();
        template.append("------------------------ CV CONTENT ------------------------").append("\n");

        template.append("Dear ").append(company.getCompanyName()).append(",\n")
                .append(message).append("\n")
                .append("Best regards,\n")
                .append(user.getUserName()).append("\n")
                .append("Date: ").append(dateFormat.format(this.date)).append("\n");

        template.append("------------------------------------------------------------").append("\n");
        template.append("Status: ").append(this.status).append("\n");
        template.append("------------------------------------------------------------").append("\n");

        return template.toString();
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

}
