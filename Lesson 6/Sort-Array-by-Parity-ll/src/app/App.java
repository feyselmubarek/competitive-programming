package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = new int[20000];

        for (int j = 0; j < 20000; j++) {
            array[j] = j + 1;
        }

        int[] b = { 4, 2, 5, 7 };
        int[] a = new Solution().sortArrayByParityII(array);

        // System.out.println();
        // System.out.print("[ ");
        // for (int i : a) {
        // System.out.print(i + ", ");
        // }
        // System.out.print(" ]");
        // System.out.println();
    }
}