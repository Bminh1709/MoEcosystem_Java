package Entities;

import java.util.Date;

public class Contract {
    private static int idCount = 1;
    private int contractId;
    private String sender;
    private String receiver;
    private Date date;
    private String skill;
    private boolean isSign = false;
    private String content;

    public Contract(String sender, String receiver, String skill) {
        this.contractId = idCount++;
        this.sender = sender;
        this.receiver = receiver;
        this.skill = skill;
        this.date = new Date();
    }

    public String ContractTemplate(String customMessage) {
        String persuasiveMessage = (customMessage != null) ?
                customMessage :
                "We're excited to collaborate with you! Your talent and recognition are a perfect match for our event, and your participation will elevate the audience experience.";

        StringBuilder template = new StringBuilder();
        template.append("Dear ").append(this.receiver).append(",\n")
                .append(persuasiveMessage).append("\n")
                .append("\n")
                .append("Date: ").append(this.date).append("\n")
                .append("Content: ").append(this.skill).append("\n")
                .append("\n")
                .append("Best regards,\n")
                .append(this.sender);

        return template.toString();
    }
}
