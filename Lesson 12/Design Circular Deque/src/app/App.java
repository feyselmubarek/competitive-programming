package app;

public class App {
    public static void main(String[] args) throws Exception {
        // MyCircularDeque circularDeque = new MyCircularDeque(2); // set the size to be
        // System.out.println(circularDeque.insertFront(7));
        // System.out.println(circularDeque.deleteLast());
        // System.out.println(circularDeque.getFront());
        // System.out.println(circularDeque.insertLast(5));
        // System.out.println(circularDeque.insertFront(0));
        // System.out.println(circularDeque.getFront());
        // System.out.println(circularDeque.getRear());
        // System.out.println(circularDeque.getFront());
        // System.out.println(circularDeque.getFront());
        // System.out.println(circularDeque.getRear());
        // System.out.println(circularDeque.insertLast(0));

        // System.out.println(circularDeque.insertFront(2));
        // System.out.println(circularDeque.getFront());
        // System.out.println(circularDeque.isEmpty());
        // System.out.println(circularDeque.front);
        // System.out.println(circularDeque.last);
        // System.out.println(circularDeque.deleteFront());

        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1)); // return true
        System.out.println(circularQueue.enQueue(2)); // return true
        System.out.println(circularQueue.enQueue(3)); // return true
        System.out.println(circularQueue.enQueue(4)); // return false, the queue is full
        System.out.println(circularQueue.Rear()); // return 3
        System.out.println(circularQueue.isFull()); // return true
        System.out.println(circularQueue.deQueue()); // return true
        System.out.println(circularQueue.enQueue(4)); // return true
        System.out.println(circularQueue.Rear()); // return 4
    }
}