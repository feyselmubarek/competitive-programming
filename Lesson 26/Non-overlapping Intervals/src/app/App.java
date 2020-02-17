package app;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new EndComparator());

        int last = intervals[0][1];
        int removal = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < last) {
                removal++;
                continue;
            }

            last = intervals[i][1];
        }

        return removal;
    }
}

class EndComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] e1, int[] e2) {
        if (e1[1] < e2[1]) {
            return -1;
        } else if (e1[1] == e2[1]) {
            if (e1[0] > e2[0]) {
                return -1;
            } else if (e1[0] == e2[0]) {
                return 0;
            }
        }

        return 1;
    }
}