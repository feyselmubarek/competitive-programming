package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().findLongestChain(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } }));
    }

    public int findLongestChain(int[][] pairs) {
        pairs = sort(pairs);
        return getLongest(pairs);
    }

    public int getLongest(int[][] pairs) {
        int totMax = 0;

        for (int i = 0; i < pairs.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    if (pairs[j][0] > max) {
                        max = pairs[j][0];
                    }
                }
            }

            pairs[i][0] = max + 1;
            totMax = Math.max(totMax, max + 1);
        }

        return totMax;
    }

    public static int[][] sort(int[][] array) {

        int len = array.length;
        int[][] left = new int[len / 2][2], right = new int[len - len / 2][2];

        if (len == 1) {
            return array;
        } else {
            left = sort(Arrays.copyOfRange(array, 0, len / 2));
            right = sort(Arrays.copyOfRange(array, len / 2, len));
        }
        return mergeSort(left, right);
    }

    public static int[][] mergeSort(int[][] left_arr, int[][] right_arr) {

        int l = 0;
        int r = 0;
        int[][] merged = new int[left_arr.length + right_arr.length][3];
        int inserted = 0;

        while ((l < left_arr.length) && (r < right_arr.length)) {
            if (left_arr[l][0] < right_arr[r][0]) {
                merged[inserted] = left_arr[l];
                l++;
            } else {
                merged[inserted] = right_arr[r];
                r++;
            }
            inserted++;
        }

        if (l == left_arr.length) {
            for (int i = r; i < right_arr.length; i++) {
                merged[inserted] = right_arr[i];
                inserted++;
            }
        } else {
            for (int i = l; i < left_arr.length; i++) {
                merged[inserted] = left_arr[i];
                inserted++;
            }
        }

        return merged;
    }

}