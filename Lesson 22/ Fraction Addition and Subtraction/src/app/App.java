// question-link : https://leetcode.com/problems/fraction-addition-and-subtraction/
package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().fractionAddition("-1/3+1/2"));
        // System.out.println(new App().findGCD(-5, 50));
    }

    public String fractionAddition(String expression) {
        // considering the form => (a/b) + (c/d)
        int a = 0, b = 1, c = 0, d = 0;
        boolean isTheOperatorPlus = true;
        String number = "";
        int starter = 0;

        if (expression.charAt(0) == '-') {
            starter = 1;
            isTheOperatorPlus = false;
        }

        for (int i = starter; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '-') {
                d = Integer.parseInt(number);

                a = isTheOperatorPlus ? (a * d) + (b * c) : (a * d) - (b * c);
                b = b * d;

                int gcd = findGCD(Math.abs(a), Math.abs(b));
                a = a / gcd;
                b = b / gcd;

                isTheOperatorPlus = false;
                number = "";

            } else if (ch == '+') {
                d = Integer.parseInt(number);

                a = isTheOperatorPlus ? (a * d) + (b * c) : (a * d) - (b * c);
                b = b * d;

                int gcd = findGCD(Math.abs(a), Math.abs(b));
                a = a / gcd;
                b = b / gcd;

                isTheOperatorPlus = true;
                number = "";

            } else if (ch == '/') {
                c = Integer.parseInt(number);
                number = "";
            } else {
                number += ch;
            }
        }

        d = Integer.parseInt(number);

        a = isTheOperatorPlus ? (a * d) + (b * c) : (a * d) - (b * c);
        b = b * d;

        int gcd = findGCD(Math.abs(a), Math.abs(b));
        a = a / gcd;
        b = b / gcd;

        return a + "/" + b;
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}