package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> myDoublyLinkedList = new MyDoublyLinkedList<>();

        myDoublyLinkedList.add(10);
        myDoublyLinkedList.add(20);
        myDoublyLinkedList.add(30);
        myDoublyLinkedList.add(40);
        myDoublyLinkedList.add(80);
        myDoublyLinkedList.addFirst(50);

        System.out.println("Original List: " + myDoublyLinkedList.toString());

        System.out.println("Is contain 60: " + myDoublyLinkedList.contains(60));
        System.out.println("Is contain 20: " + myDoublyLinkedList.contains(20));

        System.out.println("First element: " + myDoublyLinkedList.peekFirst());
        System.out.println("Last element: " + myDoublyLinkedList.peekLast());

        System.out.println("First element to remove: " + myDoublyLinkedList.removeFirst());
        System.out.println(myDoublyLinkedList.toString());

        System.out.println("Last element to remove: " + myDoublyLinkedList.removeLast());
        System.out.println(myDoublyLinkedList.toString());

        System.out.println("Remove element: " + myDoublyLinkedList.remove(20));
        System.out.println(myDoublyLinkedList.toString());

        System.out.println("Element 0 to remove: " + myDoublyLinkedList.removeAt(0));
        System.out.println(myDoublyLinkedList.toString());



//        mySet.add("Monkey");
//        System.out.println("After adding a new vocabulary: " + mySet.toString());
//
//        System.out.println("Next card of card 'Dog' is " + mySet.moveNext("Dog"));
//        System.out.println("Previous card of card 'Dog' is " + mySet.moveBack("Dog"));


    }
}
