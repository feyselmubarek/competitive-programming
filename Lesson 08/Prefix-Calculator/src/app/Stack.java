package app;

import java.util.ArrayList;

public class Stack {

    private ArrayList<String> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public String pop() {
        return stack.remove(stack.size() - 1);
    }

    public void push(String c) {
        stack.add(c);
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

}