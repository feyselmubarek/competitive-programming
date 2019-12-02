package app;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Calculator
 */
public class Calculator {
    Set<String> operators = new HashSet<>();
    Stack stack = new Stack();

    public void performPrefixCalculation(String exp) {
        Collections.addAll(operators, "+", "-", "*", "/");
        String[] expression = exp.split(" ");

        for (int i = expression.length - 1; i >= 0; i--) {
            String c = expression[i];

            if (!operators.contains(c)) {
                stack.push(c);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());

                stack.push(performOperation(a, b, c) + "");
            }
        }

        int result = Integer.parseInt(stack.pop());

        System.out.println("result: " + result);

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
}