package app;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 9, 10, 8);
        new Count().performCountingSort(arrayList);

        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(1, 1);
        // map.put(10, 10);
        // map.put(5, 5);
        // map.put(3, 3);

        // for (int i : map.keySet()) {
        // System.out.println(i);
        // }
    }
}