package Helpers;

public class GenerateId {
    private static int CvIdCount = 1;

    public static int generateCvId() {
        return CvIdCount++;
    }

}
