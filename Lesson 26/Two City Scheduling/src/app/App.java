package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;

        int[][] mergeSorted = merge2Dsort(costs);
        int len = mergeSorted.length;

        for (int k = 0; k < len; k++) {
            minCost += k < len / 2 ? mergeSorted[k][0] : mergeSorted[k][1];
        }

        return minCost;
    }

    public int[][] merge2Dsort(int[][] array) {
        if (array.length == 1) {
            return array;
        }

        int[][] leftArr = merge2Dsort(Arrays.copyOfRange(array, 0, array.length / 2));
        int[][] rightArr = merge2Dsort(Arrays.copyOfRange(array, leftArr.length, array.length));

        int[][] res = new int[array.length][];

        int i = 0, j = 0, index = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if ((leftArr[i][0] - leftArr[i][1]) < (rightArr[j][0] - rightArr[j][1])) {
                res[index] = leftArr[i];
                i++;
            } else {
                res[index] = rightArr[j];
                j++;
            }

            index++;
        }

        if (i == leftArr.length) {
            while (j < rightArr.length) {
                res[index] = rightArr[j];
                j++;
                index++;
            }
        } else if (j == rightArr.length) {
            while (i < leftArr.length) {
                res[index] = leftArr[i];
                i++;
                index++;
            }
        }

        return res;
    }
}