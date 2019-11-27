package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = new int[10];

        for (int j = 0; j < 10; j++) {
            array[j] = j + 1;
        }

        int[] b = { 4, 2, 5, 7 };
        int[] c = { 1, 2, 2, 4, 4, 5, 7, 6, 9, 7, 20 };
        int[] a = new Solution().relativeSortArray(c, b);

        System.out.println();
        System.out.print("[ ");
        for (int i : c) {
            System.out.print(i + ", ");
        }
        System.out.print(" ]");
        System.out.println();

        System.out.println();
        System.out.print("[ ");
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.print(" ]");
        System.out.println();
    }
}