package app;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] array = new int[][] { { 0, 1 } };
        Arrays.sort(array, new TwoDArrayComparator());

        System.out.println(new App().videoStitching(array, 1));

    }

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new TwoDArrayComparator());

        int[] memo = new int[clips.length + 1];
        int min = Integer.MAX_VALUE;

        for (int i = clips.length - 1; i >= 0; i--) {
            if (clips[i][0] <= T && clips[i][1] >= T) {
                min = Math.min(min, getMinPath(memo, clips, i));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int getMinPath(int[] memo, int[][] clips, int n) {
        if (memo[n] == 0) {
            int a = clips[n][0];

            if (a == 0) {
                memo[n] = 1;
                return 1;
            }

            int min = Integer.MAX_VALUE;

            for (int i = n - 1; i >= 0; i--) {
                if (clips[i][0] <= a && clips[i][1] >= a) {
                    min = Math.min(min, getMinPath(memo, clips, i));
                }
            }

            memo[n] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
        }

        return memo[n];
    }
}

class TwoDArrayComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[1] < o2[1]) {
            return -1;
        } else if (o1[1] > o2[1]) {
            return 1;
        }

        return 0;
    }
}