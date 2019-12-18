package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 2;
        A[2] = 4;
        A[3] = 1;
        A[4] = 5;

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        list = new Solution().pancakeSort(list.stream().mapToInt(i -> i).toArray());

        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}