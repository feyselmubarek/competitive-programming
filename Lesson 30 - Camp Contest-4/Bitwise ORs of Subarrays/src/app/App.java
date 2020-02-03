package app;

import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().subarrayBitwiseORs(new int[] { 1, 2, 4 }));
    }

    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();

        res.add(A[0]);
        prev.add(A[0]);

        for (int i = 1; i < A.length; i++) {
            HashSet<Integer> curr = new HashSet<>();
            curr.add(A[i]);
            res.add(A[i]);

            for (Integer integer : prev) {
                res.add(A[i] | integer);
                curr.add(A[i] | integer);
            }

            prev = curr;
        }

        return res.size();
    }
}