package app;

public class App {
    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // returns 1
        System.out.println(queue.pop()); // returns 1
        System.out.println(queue.empty()); // returns false
    }
}