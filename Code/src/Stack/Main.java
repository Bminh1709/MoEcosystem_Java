package Stack;


import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();
//        System.out.println("Frist size" + myStack.size());
//        myStack.push(4);
//        myStack.push(5);
//        myStack.push(6);
//        myStack.push(7);

//        System.out.println("Second Size" + myStack.size());
//
//        System.out.println("Remove element" + myStack.pop());
//
//        System.out.println("Top element" + myStack.peek());

        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);

//        Iterator<Integer> curVal = myStack.iterator();
//
//        System.out.println(curVal.hasNext());
//        System.out.println(curVal.next());
//        System.out.println(curVal.hasNext());
//        System.out.println(curVal.next());
//        System.out.println(curVal.hasNext());
//        System.out.println(curVal.next());
//        System.out.println(curVal.hasNext());
//        System.out.println(curVal.next());
//        System.out.println(curVal.hasNext());

        System.out.println(myStack.toString());

    }
}
