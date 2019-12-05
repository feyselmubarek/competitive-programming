package app;

public class Solution {
    public void sortColors(int[] nums) {
        performQuickSort(0, (nums.length - 1),nums);
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