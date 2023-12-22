package Queue;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> myQueue = new Queue<Integer>();
//
//        myQueue.offer(1);
//        myQueue.offer(2);
//        myQueue.offer(3);
////        myQueue.offer(4);
////        myQueue.offer(5);
//
//        myQueue.poll();
//        myQueue.poll();
//        myQueue.poll();
//
//        myQueue.offer(3);
////        System.out.println("Top element: " + myQueue.peek());
////
////        System.out.println("Original size: " + myQueue.size());
////
////        System.out.println("Removed element: " + myQueue.poll());
////
////        System.out.println("Top element: " + myQueue.peek());
//
//        System.out.println("Current size: " + myQueue.size());

        Queue<String> siteQueue = new Queue<String>();

        System.out.println("First user in queue: Nam");
        siteQueue.offer("Nam");
        System.out.println("Second user in queue: Long");
        siteQueue.offer("Long");
        System.out.println("Third user in queue: Minh");
        siteQueue.offer("Minh");

        System.out.println("====== EXECUTING ======");

        System.out.println("First user is executed: " + siteQueue.poll());
        System.out.println("Second user is executed: " + siteQueue.poll());
        System.out.println("Third user is executed: " + siteQueue.poll());
    }
}
