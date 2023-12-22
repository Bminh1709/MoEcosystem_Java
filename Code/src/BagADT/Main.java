package BagADT;

public class Main {
    public static void main(String[] args) {

        ArrayBag newArrayBag = new ArrayBag(2);

        newArrayBag.add("minh");
        newArrayBag.add("nam");
        newArrayBag.add("hung"); // ni nef
        newArrayBag.add("duy");
        newArrayBag.add("thanh");
        newArrayBag.add("tu");

        newArrayBag.remove("hung");

        //System.out.println(newArrayBag.numItems());
        //System.out.println(newArrayBag.contains("huy"));
        Object[] test = newArrayBag.toArray();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }

    }
}
