package app;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxIndex = 0;

        for (int i = 0; i < A.length; i++) {
            int last = (A.length - 1) - i;
            maxIndex = getMaxIndex(A, 0, last);

            if ((maxIndex + 1) != A[maxIndex]) {
                if (maxIndex != 0) {
                    flip(A, 0, maxIndex);
                    list.add(maxIndex + 1);
                }

                if (last != 0) {
                    flip(A, 0, last);
                    list.add(last + 1);
                }
            }
        }
        return list;
    }

    private void flip(int[] a, int i, int last) {
        while (i < last) {
            int temp = a[i];
            a[i] = a[last];
            a[last] = temp;
            i++;
            last--;
        }
    }

    private int getMaxIndex(int[] a, int i, int j) {
        int index = 0, max = 0;
        for (int k = i; k <= j; k++) {
            if (a[k] > max) {
                max = a[k];
                index = k;
            }
        }
        return index;
    }
}