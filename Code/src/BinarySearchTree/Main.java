package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> myBinarySearchTree = new MyBinarySearchTree<>();

        myBinarySearchTree.insert(7);
        myBinarySearchTree.insert(5);
        myBinarySearchTree.insert(20);
        myBinarySearchTree.insert(4);
        myBinarySearchTree.insert(6);
        myBinarySearchTree.insert(2);
        myBinarySearchTree.insert(30);
        myBinarySearchTree.insert(45);
        myBinarySearchTree.insert(35);
        myBinarySearchTree.insert(25);
        myBinarySearchTree.insert(40);
        myBinarySearchTree.insert(35);

//        System.out.println("Min is: " + myBinarySearchTree.findMin());
//        System.out.println("Max is: " + myBinarySearchTree.findMax());
//
//        // myBinarySearchTree.delete(30);
//
//        System.out.println(myBinarySearchTree.height());

        // myBinarySearchTree.inorderTraversal();
//        myBinarySearchTree.preorderTraversal();
//        System.out.println(myBinarySearchTree.height());

        long begin = System.nanoTime();
        //Starting the watch
        //End time
        long end = System.nanoTime();
        long time = end-begin;
        System.out.println();
        System.out.println("Elapsed Time: "+time);
    }
}
