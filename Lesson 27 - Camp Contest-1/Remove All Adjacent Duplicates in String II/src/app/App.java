package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(s.charAt(0), 1);

        stack.push(pair);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(new Pair(c, 1));
            } else {
                Pair p = stack.peek();
                if (c == p.c) {
                    p.occ += 1;
                    if (p.occ == k) {
                        stack.pop();
                    }
                } else {
                    stack.push(new Pair(c, 1));
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            Pair p = stack.pop();

            for (int j = 0; j < p.occ; j++) {
                stringBuilder.insert(0, p.c);
            }
        }

        return stringBuilder.toString();
    }
}

class Pair {
    public char c;
    public int occ;

    public Pair(char c, int occ) {
        this.c = c;
        this.occ = occ;
    }
}