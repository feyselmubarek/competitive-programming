package app;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Radix
 */
public class Radix {
    private ArrayList<Integer> result;

    public ArrayList<Integer> performRadixSort(ArrayList<Integer> arrayList) {
        result = arrayList;

        ArrayList<Integer> sampleNumbers = new ArrayList<>();
        int s = 10;

        for (int j = 0; j < 3; j++) {
            sampleNumbers.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                sampleNumbers.add(arrayList.get(i) % s);
            }
            s *= 10;

            performQuickSort(0, sampleNumbers.size() - 1, sampleNumbers);
        }

        System.out.println();
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + ", ");
        }
        System.out.println();

        return result;
    }

    public void performQuickSort(int initialIndex, int finalIdnex, ArrayList<Integer> arrayList) {

        if (initialIndex < finalIdnex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIdnex, arrayList);
            performQuickSort(initialIndex, pivIndex - 1, arrayList);
            performQuickSort(pivIndex + 1, finalIdnex, arrayList);
        }
    }

    public int getSortedPivotIndex(int intialIndex, int finalIndex, ArrayList<Integer> arrayList) {
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
                Collections.swap(result, intialIndex, finalIndex);
            }
        }

        if (finalIndex > pivotIndex) {
            Collections.swap(arrayList, finalIndex, pivotIndex);
            Collections.swap(result, finalIndex, pivotIndex);
            return finalIndex;
        }
        return pivotIndex;
    }
}