package app;

public class Solution {
    public int hIndex(int[] citations) {
        performReverseQuickSort(0, citations.length - 1, citations);
        int val = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= i + 1 && citations[i] != 0) {
                val = i + 1;
            }
        }

        return val;
    }

    public void performReverseQuickSort(int initialIndex, int finalIdnex, int[] array) {

        if (initialIndex < finalIdnex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIdnex, array);
            performReverseQuickSort(initialIndex, pivIndex - 1, array);
            performReverseQuickSort(pivIndex + 1, finalIdnex, array);
        }
    }

    public int getSortedPivotIndex(int intialIndex, int finalIndex, int[] array) {
        int pivot = array[intialIndex];
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (array[intialIndex] >= pivot) {
                    intialIndex++;
                }

                while (array[finalIndex] <= pivot) {
                    finalIndex--;
                }
            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                int temp = array[intialIndex];
                array[intialIndex] = array[finalIndex];
                array[finalIndex] = temp;
            }
        }

        if (finalIndex > pivotIndex) {
            int temp = array[pivotIndex];
            array[pivotIndex] = array[finalIndex];
            array[finalIndex] = temp;

            return finalIndex;
        }
        return pivotIndex;
    }
}