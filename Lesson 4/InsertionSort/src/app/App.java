package app;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        RandomGenerator generator = new RandomGenerator();
        performInsertionSort(generator.getRandomNumber(10000));
    }

    public static void performInsertionSort(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (arrayList.get(i) < arrayList.get(j)) {
                    Collections.swap(arrayList, i, j);
                }
            }
        }

        System.out.print("[ ");
        for (Integer integer : arrayList) {
            System.out.print(integer + ", ");
        }
        System.out.print(" ]");

    }
}