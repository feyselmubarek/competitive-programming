package app;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        Set<Integer> set = new HashSet<>();

        for (int integer : arr2) {
            set.add(integer);
        }

        int[] notFound = new int[arr1.length - arr2.length];

        int counter = 0, v = 0;

        for (int i = 0; i < arr2.length; i++) {
            v = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    result[counter] = arr1[j];
                    counter++;
                } else if (!set.contains(arr1[j])) {
                    notFound[v] = arr1[j];
                    v++;
                }
            }
        }

        for (int k = counter; k < arr1.length; k++) {
            result[k] = notFound[k - counter];
        }

        performQuickSort(counter, arr1.length - 1, result);

        return result;
    }

    public void performQuickSort(int initialIndex, int finalIdnex, int[] array) {

        if (initialIndex < finalIdnex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIdnex, array);
            performQuickSort(initialIndex, pivIndex - 1, array);
            performQuickSort(pivIndex + 1, finalIdnex, array);
        }
    }

    public int getSortedPivotIndex(int intialIndex, int finalIndex, int[] array) {
        int pivot = array[intialIndex];
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (array[intialIndex] <= pivot) {
                    intialIndex++;
                }

                while (array[finalIndex] >= pivot) {
                    finalIndex--;
                }
            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                int temp = array[intialIndex];
                int temp2 = array[finalIndex];

                array[intialIndex] = temp2;
                array[finalIndex] = temp;
            }
        }

        if (finalIndex > pivotIndex) {
            int temp = array[pivotIndex];
            int temp2 = array[finalIndex];

            array[pivotIndex] = temp2;
            array[finalIndex] = temp;

            return finalIndex;
        }
        return pivotIndex;
    }
}