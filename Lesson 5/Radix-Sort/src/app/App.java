package app;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 53, 89, 180, 90, 150, 36, 633, 233);

        new Radix().performRadixSort(integers);
    }
}