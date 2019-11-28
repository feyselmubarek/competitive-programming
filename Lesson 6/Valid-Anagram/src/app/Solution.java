package app;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> occuranceCounter = new HashMap<>();

        if (t.length() > s.length()) {
            String temp = t;
            t = s;
            s = temp;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (occuranceCounter.containsKey(c)) {
                occuranceCounter.put(c, (occuranceCounter.get(c) + 1));
            } else {
                occuranceCounter.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (occuranceCounter.containsKey(c)) {
                if (occuranceCounter.get(c) > 1) {
                    occuranceCounter.put(c, (occuranceCounter.get(c) - 1));
                } else {
                    occuranceCounter.remove(c);
                }
            }
        }

        return occuranceCounter.size() == 0;
    }
}