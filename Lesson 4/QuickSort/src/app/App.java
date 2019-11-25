package app;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList = new RandomGenerator().getRandomNumber(10000);
        performQuickSort(0, (arrayList.size() - 1), arrayList);

        System.out.println();
        System.out.print("[ ");
        for (Integer integer : arrayList) {
            System.out.print(integer + ", ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    public static void performQuickSort(int initialIndex, int finalIdnex, ArrayList<Integer> arrayList) {

        if (initialIndex < finalIdnex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIdnex, arrayList);
            performQuickSort(initialIndex, pivIndex - 1, arrayList);
            performQuickSort(pivIndex + 1, finalIdnex, arrayList);
        }
    }

    public static int getSortedPivotIndex(int intialIndex, int finalIndex, ArrayList<Integer> arrayList) {
        int pivot = arrayList.get(intialIndex);
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (arrayList.get(intialIndex) <= pivot) {
                    intialIndex++;
                }

                while (arrayList.get(finalIndex) >= pivot) {
                    finalIndex--;
                }
            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                Collections.swap(arrayList, intialIndex, finalIndex);
            }
        }

        if (finalIndex > pivotIndex) {
            Collections.swap(arrayList, finalIndex, pivotIndex);
            return finalIndex;
        }
        return pivotIndex;
    }
}