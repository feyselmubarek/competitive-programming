package app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().maxEvents(new int[][] { { 52, 79 }, { 7, 34 } }));
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new StartComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = events[0][0];
        int e_index = 0;
        int count = 0;

        while (day <= 100000) {
            while (minHeap.size() > 0 && day > minHeap.peek()) {
                minHeap.poll();
            }

            while (e_index < events.length && events[e_index][0] == day) {
                minHeap.add(events[e_index][1]);
                e_index++;
            }

            if (minHeap.size() > 0 && day <= minHeap.peek()) {
                minHeap.poll();
                count++;
            }

            day++;
        }

        return count;
    }
}

class StartComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] e1, int[] e2) {
        if (e1[0] < e2[0]) {
            return -1;
        } else if (e1[0] > e2[0]) {
            return 1;
        }
        return 0;
    }
}