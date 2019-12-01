package app;

public class Solution {

    public int largestPerimeter(int[] A) {

        performReverseQuickSort(0, A.length - 1, A);

        for (int i = 0; i < A.length - 2; i++) {
            if (checkValidity(A[i], A[i + 1], A[i + 2])) {
                return (A[i] + A[i + 1] + A[i + 2]);
            }
        }

        return 0;
    }

    private boolean checkValidity(int i, int j, int k) {
        if (i + j > k && i + k > j && k + j > i) {
            return true;
        }
        return false;
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