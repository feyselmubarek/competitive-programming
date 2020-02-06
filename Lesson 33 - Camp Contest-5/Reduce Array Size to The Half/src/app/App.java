package app;

import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().minSetSize(new int[] { 1, 23, 42, 23 }));
    }

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }

        Object[] a = map.values().toArray();
        int[] sumArr = new int[a.length + 1];
        int sum = 0;
        Arrays.sort(a);

        for (int i = 0; i < sumArr.length; i++) {
            sumArr[i] = sum;
            if (i < a.length) {
                sum += (int) a[i];
            }
        }

        int min = Integer.MAX_VALUE, i = 0, j = 0, target = arr.length / 2;

        while (j < sumArr.length) {
            if (sumArr[j] - sumArr[i] < target) {
                j++;
            } else if (sumArr[j] - sumArr[i] >= target) {
                if (min > (j - i)) {
                    min = j - i;
                }
                i++;
            }
        }

        return min;
    }
}