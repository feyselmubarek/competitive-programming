package app;

public class App {
    public static void main(String[] args) throws Exception {
        // MinStack minStack = new MinStack();

        // ArrayList<Integer> list = new ArrayList<>();

        // System.out.println(Collections.min(list));

        // minStack.pop();
        // minStack.push(2147483646);
        // minStack.push(2147483646);
        // minStack.push(2147483647);

        // minStack.top();
        // minStack.pop();

        // System.out.println(minStack.getMin());
        // minStack.pop();
        // System.out.println(minStack.getMin());
        // minStack.pop();
        // minStack.push(2147483647);
        // minStack.top();
        // System.out.println(minStack.getMin());
        // minStack.push(-2147483648);
        // System.out.println(minStack.top());
        // System.out.println(minStack.getMin());
        // minStack.pop();
        // System.out.println(minStack.getMin());

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}