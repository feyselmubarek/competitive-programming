package app;

public class Solution {
    int[][] result;

    public int[][] kClosest(int[][] points, int K) {
        result = points;

        if (points != null && points.length > 1) {
            int[] temp = new int[points.length];

            for (int i = 0; i < points.length; i++) {
                int distance = (int) getDistanceFromOrigin(points[i]);
                temp[i] = distance;
            }

            performQuickSort(0, points.length - 1, temp);

            int len = K <= points.length ? K : points.length;

            int[][] res = new int[len][];

            for (int j = 0; j < len; j++) {
                res[j] = points[j];
            }

            return res;
        }

        return points;
    }

    public double getDistanceFromOrigin(int[] array) {
        return Math.pow((array[0]), 2) + Math.pow((array[1]), 2);
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

                int[] tempArray = result[intialIndex];
                result[intialIndex] = result[finalIndex];
                result[finalIndex] = tempArray;
            }
        }

        if (finalIndex > pivotIndex) {
            int temp = array[pivotIndex];
            array[pivotIndex] = array[finalIndex];
            array[finalIndex] = temp;

            int[] tempArray = result[pivotIndex];
            result[pivotIndex] = result[finalIndex];
            result[finalIndex] = tempArray;

            return finalIndex;
        }
        return pivotIndex;
    }
}