package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int maxDistToClosest(int[] seats) {
        boolean leftOne = false;
        int leftIndex = 0, res = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (!leftOne) {
                    leftOne = true;
                    res = Math.max(res, (i - 0));
                } else {
                    res = Math.max(res, ((i - leftIndex) / 2));
                }

                leftIndex = i;
            }
        }

        res = Math.max(res, (seats.length - (1 + leftIndex)));

        return res;
    }
}