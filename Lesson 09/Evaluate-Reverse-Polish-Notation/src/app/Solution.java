package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    Stack stack;
    Set<String> operators;

    public int evalRPN(String[] tokens) {
        operators = new HashSet<>();
        stack = new Stack();

        Collections.addAll(operators, "+", "-", "*", "/");

        for (int i = 0; i < tokens.length; i++) {
            String string = tokens[i];
            if (!operators.contains(string)) {
                stack.push(string);
            } else {
                String b = stack.pop();
                String a = stack.pop();

                if (a != null && b != null) {
                    int num1 = Integer.parseInt(a);
                    int num2 = Integer.parseInt(b);

                    stack.push(performOperation(num1, num2, string) + "");
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public int performOperation(int num1, int num2, String sign) {
        int result;

        if (sign.equals("+")) {
            result = num1 + num2;
        } else if (sign.equals("-")) {
            result = num1 - num2;
        } else if (sign.equals("*")) {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }

        return result;
    }

    class Stack {

        private ArrayList<String> stack;

        public Stack() {
            stack = new ArrayList<>();
        }

        public String pop() {
            if (getSize() > 0) {
                return stack.remove(stack.size() - 1);
            }
            return null;
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
}