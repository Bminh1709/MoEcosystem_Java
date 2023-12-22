package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {
    private int size;
    private Node<T> root;

    public MyBinarySearchTree() {
        this.size = 0;
        this.root = null;
    }

    @Override
    public void insert(T data) {
        if (contains(data))
            throw new NullPointerException("The data is existed");
        // root = insertHelper(root, data);
        if (root == null)
            root = new Node<>(data, null, null);
        else
            insertHelper(root, data);
        size++;
    }

    private void insertHelper(Node<T> curNode, T data) {
        int compareResult = data.compareTo(curNode.data);

        if (compareResult < 0) // data < curNode.data
        {
            if (curNode.left == null)
                curNode.left = new Node<>(data, null, null);
            else
                insertHelper(curNode.left, data);
        }
        else // data > curNode.data
        {
            if (curNode.right == null)
                curNode.right = new Node<>(data, null, null);
            else
                insertHelper(curNode.right, data);
        }
    }

//    private Node insertHelper(Node<T> curNode, T data) {
//        if (curNode == null) {
//            curNode = new Node<>(data);
//            return curNode;
//        }
//        else {
//            int compareResult = data.compareTo(curNode.data);
//
//            if (compareResult < 0) // data < curNode.data
//                curNode.left = insertHelper(curNode.left, data);
//            else // data > curNode.data
//                curNode.right = insertHelper(curNode.right, data);
//
//            return curNode;
//        }
//    }

    @Override
    public void delete(T data) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");
        if (!contains(data))
            throw new NullPointerException("The data is not existed");

        root = deleteHelper(root, data);
        size--;
    }

    private Node<T> deleteHelper(Node<T> curNode, T data) {
        int compareResult = data.compareTo(curNode.data);

        if (compareResult < 0) // data < curNode.data
            curNode.left = deleteHelper(curNode.left, data);
        else if (compareResult > 0) // data > curNode.data
            curNode.right = deleteHelper(curNode.right, data);
        // data is found
        else {
            if (curNode.left == null) {
                Node<T> rightNode = curNode.right;
                curNode = null;
                return rightNode;
            }
            else if (curNode.right == null) {
                Node<T> leftNode = curNode.left;
                curNode = null;
                return leftNode;
            } else {
                // Find min of rightNode
                T replacedData = findMinRightData(curNode.right);
                // Replace data for current removed Node
                curNode.data = replacedData;
                // Remove that replaced Node
                curNode.right = deleteHelper(curNode.right, replacedData);
            }
        }
        return curNode;
    }

    private T findMinRightData(Node<T> curNode) {
        while (curNode.left != null)
            curNode = curNode.left;
        return curNode.data;
    }

    @Override
    public boolean contains(T data) {
        return containsHelper(root, data);
    }

    private boolean containsHelper(Node<T> curNode, T data) {
        if (curNode == null) // end of the chain
            return false;

        int compareResult = data.compareTo(curNode.data);

        if (compareResult < 0) // data < curNode.data
            return containsHelper(curNode.left, data);
        else if (compareResult > 0) // data > curNode.data
            return containsHelper(curNode.right, data);
        return true; // data == curNode.data
    }

    @Override
    public T findMin() {
        Node<T> curNode = root;
        while (curNode.left != null)
            curNode = curNode.left;
        return curNode.data;
    }

    @Override
    public T findMax() {
        Node<T> curNode = root;
        while (curNode.right != null)
            curNode = curNode.right;
        return curNode.data;
    }

    @Override
    public void inorderTraversal() {
        inorderTraversalHelper(root);
    }

    private void inorderTraversalHelper(Node<T> curNode) {
        if (curNode != null) {
            inorderTraversalHelper(curNode.left);
            System.out.print(curNode.data + " ");
            inorderTraversalHelper(curNode.right);
        }
    }

    @Override
    public void preorderTraversal() {
        preorderTraversalHelper(root);
    }

    private void preorderTraversalHelper(Node<T> curNode) {
        if (curNode != null) {
            System.out.print(curNode.data + " ");
            preorderTraversalHelper(curNode.left);
            preorderTraversalHelper(curNode.right);
        }
    }

    @Override
    public void postorderTraversal() {

    }

    @Override
    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(Node<T> curNode) {
        if (curNode == null) return 0;
        int leftHeight = heightHelper(curNode.left);
        int rightHeight = heightHelper(curNode.right);

        // return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = clearHelper(root);
        size = 0;
    }

    private Node<T> clearHelper(Node<T> curNode) {
        if (curNode == null)
            return null;
        else {
            curNode.left = clearHelper(curNode.left);
            curNode.right = clearHelper(curNode.right);
        }
        return null;
    }

    public void BreathFirstSearch() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0) {
            Node<T> tmpNode = queue.poll();
            System.out.println(tmpNode.data);

            if (tmpNode.left != null) queue.offer(tmpNode.left);
            if (tmpNode.right != null) queue.offer(tmpNode.right);
        }
    }


}
