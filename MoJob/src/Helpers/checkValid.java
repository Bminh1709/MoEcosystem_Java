package Helpers;

public class checkValid {
    public static boolean isValidChoice(int start, int end, int choice) {
        if (choice >= start && choice <= end) return true;
        return false;
    }

    public static boolean isValidLength(String message) {
        if (message.length() > 250) return false;
        return true;
    }

    public static String[] devidePartsOfMessage(String message) {
        if (message.length() <= 250) return null;

        int limit = 250;
        int length = message.length();
        int parts = (int) Math.ceil((double) length / limit);

        String[] arr = new String[parts];

        for (int i = 0; i < parts; i++) {
            int startIndex = i * limit;
            int endIndex = Math.min((i + 1) * limit, length);
            arr[i] = message.substring(startIndex, endIndex);
        }

        return arr;
    }
}
