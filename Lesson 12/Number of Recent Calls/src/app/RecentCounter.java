package app;

import java.util.ArrayList;

public class RecentCounter {
    ArrayList<Integer> timeStamps;

    public RecentCounter() {
        timeStamps = new ArrayList<>();
    }

    public int ping(int t) {
        timeStamps.add(t);

        int min = t - 3000;
        int counter = 0;

        for (int i = timeStamps.size() - 1; i >= 0; i--) {
            int time = timeStamps.get(i);
            if (time >= min && time <= t) {
                counter++;
            } else {
                break;
            }
        }

        return counter;
    }
}