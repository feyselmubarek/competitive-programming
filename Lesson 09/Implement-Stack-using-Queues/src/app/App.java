package app;

public class App {
    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // returns 2
        System.out.println(stack.pop()); // returns 2
        System.out.println(stack.empty()); // returns falseSystem.out.println("Hello Java");
    }
}