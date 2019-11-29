package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, String> map;

    public boolean isValid(String s) {
        map = new HashMap<>();

        map.put("]", "[");
        map.put("}", "{");
        map.put(")", "(");

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i) + "";

            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                String parethesis = stack.pop();
                if (parethesis == null) {
                    return false;
                }
                if (!map.get(c).equals(parethesis)) {
                    return false;
                }
            }
        }

        return stack.getSize() == 0;
    }

    class Stack {
        ArrayList<String> stack = new ArrayList<>();

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