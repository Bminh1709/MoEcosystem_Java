package BinarySearchTree;

public interface BinarySearchTreeADT<T extends Comparable<T>> {
    // Method to insert a new element into the BST
    void insert(T data);

    // Method to delete an element from the BST
    void delete(T data);

    // Method to search for an element in the BST
    boolean contains(T data);

    // Method to find the minimum element in the BST
    T findMin();

    // Method to find the maximum element in the BST
    T findMax();

    // Traversal methods

    // Inorder traversal method
    void inorderTraversal();

    // Preorder traversal method
    void preorderTraversal();

    // Postorder traversal method
    void postorderTraversal();

    // Method to get the height of the BST
    int height();

    // Method to check if the BST is empty
    boolean isEmpty();

    // Method to get the number of elements in the BST
    int size();

    // Method to clear all elements in the BST
    void clear();
}
