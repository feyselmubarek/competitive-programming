package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] T = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };

        int[] a = new int[30000];

        for (int i = 30000; i > 0; i--) {
            a[30000 - i] = i;
        }
        System.out.println("begin");

        int[] res = new Solution().dailyTemperatures(a);

        for (int i : res) {
            System.out.print(i + ", ");
        }
    }
}