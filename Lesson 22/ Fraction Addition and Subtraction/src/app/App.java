// question-link : https://leetcode.com/problems/fraction-addition-and-subtraction/
package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().fractionAddition("-1/2+1/2+2/3"));
        // System.out.println(new App().findGCD(0, 4));
    }

    public String fractionAddition(String expression) {
        // considering the form => (a/b) + (c/d)
        int a = 0, b = 0, c = 0, d = 0;
        boolean isAfound = false, isBfound = false, isCfound = false;
        String number = "";

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '-') {
                if (number.equals("")) {
                    number += ch;
                } else {
                    if (!isBfound) {
                        b = Integer.parseInt(number);
                        isBfound = true;
                    } else {
                        d = Integer.parseInt(number);

                        a = (a * d) - (b * c);
                        b = b * d;

                        int gcd = findGCD(a, b);
                        a = a / gcd;
                        b = b / gcd;

                        isCfound = false;
                    }
                    number = "";
                }
            } else if (ch == '+') {
                // related b, d
                if (!isBfound) {
                    b = Integer.parseInt(number);
                    isBfound = true;
                } else {
                    d = Integer.parseInt(number);

                    a = (a * d) + (b * c);
                    b = b * d;

                    int gcd = findGCD(a, b);
                    a = a / gcd;
                    b = b / gcd;

                    isCfound = false;
                }
                number = "";
            } else if (ch == '/') {
                // related a, c
                if (!isAfound) {
                    a = Integer.parseInt(number);
                    isAfound = true;
                } else if (!isCfound) {
                    c = Integer.parseInt(number);
                    isCfound = true;
                }
                number = "";
            } else {
                number += ch;
            }
        }

        d = Integer.parseInt(number);

        a = (a * d) + (b * c);
        b = b * d;

        int gcd = findGCD(a, b);
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