package app;

class Solution {
    int[][] result;

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[] distance = new int[R * C];
        result = new int[R * C][2];
        int counter = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int mahathanDistance = Math.abs((i - r0)) + Math.abs((j - c0));
                distance[counter] = mahathanDistance;
                result[counter] = new int[] { i, j };
                counter++;
            }
        }

        performQuickSort(0, distance.length - 1, distance);

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
                int[] tempA = result[intialIndex];

                int temp2 = array[finalIndex];
                int[] tempB = result[finalIndex];

                array[intialIndex] = temp2;
                result[intialIndex] = tempB;

                array[finalIndex] = temp;
                result[finalIndex] = tempA;
            }
        }

        if (finalIndex > pivotIndex) {
            int temp = array[pivotIndex];
            int[] tempA = result[pivotIndex];

            int temp2 = array[finalIndex];
            int[] tempB = result[finalIndex];

            array[pivotIndex] = temp2;
            result[pivotIndex] = tempB;

            array[finalIndex] = temp;
            result[finalIndex] = tempA;

            return finalIndex;
        }
        return pivotIndex;
    }
}