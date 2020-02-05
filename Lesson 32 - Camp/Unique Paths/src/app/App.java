package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    // can be done by using factorial formal of permutation
    // fact(m + n - 1) / fact(m - 1) * fact(n - 1)
    // be careful with integer overflow
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[n];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }

        return arr[m - 1][n - 1];
    }
}