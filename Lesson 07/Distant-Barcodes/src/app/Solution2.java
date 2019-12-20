package app;

import java.util.Arrays;

public class Solution2 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);

        int num = -1;
        int index = -1;

        int[][] mapper = new int[barcodes.length][2];

        for (int i = 0; i < barcodes.length; i++) {
            if (barcodes[i] == num) {
                mapper[index][1] = mapper[index][1] + 1;
            } else {
                index++;
                mapper[index] = new int[] { barcodes[i], 1 };
                num = barcodes[i];
            }
        }

        performReverseQuickSort(0, mapper.length - 1, mapper);

        int zeroIndex = 0, oneIndex = 1;
        int[] result = new int[barcodes.length];

        for (int i = 0; i < result.length; i++) {
            int occ = mapper[i][1];
            int val = mapper[i][0];

            if (occ == 0) {
                return result;
            }

            while (occ > 0) {
                if (zeroIndex < result.length) {
                    result[zeroIndex] = val;
                    occ--;
                    zeroIndex += 2;

                } else if (oneIndex < result.length) {
                    result[oneIndex] = val;
                    occ--;
                    oneIndex += 2;
                }
            }
        }

        return result;
    }

    public static void performReverseQuickSort(int initialIndex, int finalIdnex, int[][] multiArray) {

        if (initialIndex < finalIdnex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIdnex, multiArray);
            performReverseQuickSort(initialIndex, pivIndex - 1, multiArray);
            performReverseQuickSort(pivIndex + 1, finalIdnex, multiArray);
        }
    }

    public static int getSortedPivotIndex(int intialIndex, int finalIndex, int[][] multiArray) {
        int pivot = multiArray[intialIndex][1];
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (multiArray[intialIndex][1] >= pivot) {
                    intialIndex++;
                }

                while (multiArray[finalIndex][1] <= pivot) {
                    finalIndex--;
                }
            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                int[] temp = multiArray[intialIndex];
                multiArray[intialIndex] = multiArray[finalIndex];
                multiArray[finalIndex] = temp;
            }
        }

        if (finalIndex > pivotIndex) {
            int[] temp = multiArray[pivotIndex];
            multiArray[pivotIndex] = multiArray[finalIndex];
            multiArray[finalIndex] = temp;

            return finalIndex;
        }
        return pivotIndex;
    }
}