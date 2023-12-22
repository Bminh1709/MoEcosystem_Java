package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        System.out.println("Original List: " + myLinkedList.toString());

        myLinkedList.add("One");
        myLinkedList.add("Two");
        myLinkedList.add("Three");
        myLinkedList.add("Four");


        myLinkedList.addFirst("Zero");
        System.out.println("After adding at first: " + myLinkedList.toString());

        System.out.println("Size: " + myLinkedList.size());

        myLinkedList.removeFirst();
        System.out.println("After removing first element: " + myLinkedList.toString());
        myLinkedList.removeLast();
        System.out.println("After removing last element: " + myLinkedList.toString());
        myLinkedList.remove("Three");
        System.out.println("After removing Three: " + myLinkedList.toString());


        System.out.println("Size: " + myLinkedList.size());

        myLinkedList.clear();

        System.out.println("Size: " + myLinkedList.size());





    }
}
