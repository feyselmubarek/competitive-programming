package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int memo[] = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        return getSubPos(n, memo);

    }

    public int getSubPos(int n, int[] memo) {
        if (memo[n] == 0) {
            int i = n - 1;
            int j = 0;
            int count = 0;

            while (i >= 0 && j < n) {
                count += getSubPos(i, memo) * getSubPos(j, memo);

                i--;
                j++;
            }

            memo[n] = count;
        }

        return memo[n];
    }
}