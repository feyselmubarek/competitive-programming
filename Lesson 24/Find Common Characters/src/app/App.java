package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().commonChars(new String[] { "bella", "label", "roller" }));
    }

    public List<String> commonChars(String[] A) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> holder = new HashMap<>();

        List<String> result = new ArrayList<>();

        for (int i = 0; i < A[0].length(); i++) {
            char c = A[0].charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);

                if (map.containsKey(c)) {
                    if (holder.containsKey(c)) {
                        if (map.get(c) >= holder.get(c) + 1) {
                            holder.put(c, holder.get(c) + 1);
                        }
                    } else {
                        holder.put(c, 1);
                    }
                }
            }
            map.clear();
            map.putAll(holder);
            holder.clear();
        }

        for (char ch : map.keySet()) {
            for (int k = 0; k < map.get(ch); k++) {
                result.add(ch + "");
            }
        }

        return result;
    }
}