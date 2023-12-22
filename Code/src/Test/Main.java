package Test;

public class Main {
    public static void main(String[] args) {
        String message = "I am reaching out to express my interest in your company. \n" +
                "My skills and experience align well with your requirements, \n" +
                "and I believe I would be a valuable addition to your team.";

        int partSize = 50;
        int length = message.length();
        int parts = (int) Math.ceil((double) length / partSize);

        // Split the string into equal parts
        for (int i = 0; i < parts; i++) {
            int startIndex = i * partSize;
            int endIndex = Math.min((i + 1) * partSize, length);
            String part = message.substring(startIndex, endIndex);
            System.out.println("Part " + (i + 1) + ": " + part);
        }
    }

}
