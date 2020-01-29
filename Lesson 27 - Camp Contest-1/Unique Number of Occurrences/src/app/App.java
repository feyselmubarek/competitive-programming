package app;

import java.util.HashMap;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int occ = map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1;
            map.put(arr[i], occ);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int key : map.keySet()) {
            if (set.contains(map.get(key))) {
                return false;
            }
            set.add(map.get(key));
        }

        return true;
    }
}