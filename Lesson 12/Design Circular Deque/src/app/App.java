package app;

public class App {
    public static void main(String[] args) throws Exception {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        System.out.println(circularDeque.insertLast(1));// return true
        System.out.println(circularDeque.insertLast(2)); // return true
        System.out.println(circularDeque.insertFront(3)); // return true
        System.out.println(circularDeque.insertFront(4)); // return false, the queue is full
        System.out.println(circularDeque.getRear()); // return 2
        System.out.println(circularDeque.isFull()); // return true
        System.out.println(circularDeque.deleteLast()); // return true
        System.out.println(circularDeque.insertFront(4)); // return true
        System.out.println(circularDeque.getFront()); // return 4

        // System.out.println(4 % 3);
    }
}