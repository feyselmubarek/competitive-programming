package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Calculator
 */
public class Calculator {
    Set<Character> operators = new HashSet<>();

    public void performPrefixCalculation(String expression) {
        Collections.addAll(operators, '+', '-', '*', '/');
        // String[] withOutLastOperand = exp.split(" ");
        ArrayList<String> operatorsInTheExp = new ArrayList<>();
        ArrayList<String> numbersInTheExp = new ArrayList<>();
        // String expression = withOutLastOperand[0];

        String result = "";
        String currentNum = "";
        String operator = "";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (operators.contains(c)) {

                operatorsInTheExp.add(c + "");
                if (!currentNum.equals("")) {
                    numbersInTheExp.add(currentNum + "");
                    System.out.println("currentNum " + currentNum);
                }

                currentNum = "";
            } else {
                if (c == ' ') {
                    numbersInTheExp.add(currentNum + "");
                    currentNum = "";

                } else {
                    currentNum += c;
                }
            }
        }
        if (!currentNum.equals("")) {
            numbersInTheExp.add(currentNum + "");
            System.out.println("currentNum " + currentNum);
        }

        int res = 0;
        result = numbersInTheExp.get(0);

        System.out.println("result: " + result);

        for (int i = 1; i < numbersInTheExp.size(); i++) {
            if (operatorsInTheExp.get(operatorsInTheExp.size() - i).equals("+")) {
                res = Integer.parseInt(result) + Integer.parseInt(numbersInTheExp.get(i));
                result = res + "";
            } else if (operatorsInTheExp.get(operatorsInTheExp.size() - i).equals("*")) {
                res = Integer.parseInt(result) * Integer.parseInt(numbersInTheExp.get(i));
                result = res + "";
            } else if (operatorsInTheExp.get(operatorsInTheExp.size() - i).equals("/")) {
                res = Integer.parseInt(result) / Integer.parseInt(numbersInTheExp.get(i));
                result = res + "";
            } else {
                res = Integer.parseInt(result) - Integer.parseInt(numbersInTheExp.get(i));
                result = res + "";
            }
        }

        System.out.println("res: " + res);
    }
}