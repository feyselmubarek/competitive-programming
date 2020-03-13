package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] n = new int[1000][];

        int[][] b = new int[][] { { 3, 3 }, { 5, 1 }, { -2, 4 } };

        for (int i = 0; i < n.length; i++) {
            n[i] = new int[] { 1000 - i, 10000 - i };
        }

        int[][] r = new Solution().kClosest(b, 2);

        // System.out.println(r == null);
        System.out.println();
        for (int[] is : r) {
            System.out.print("[ " + is[0] + ", " + is[1] + " ], ");
        }
        System.out.println();
    }
}