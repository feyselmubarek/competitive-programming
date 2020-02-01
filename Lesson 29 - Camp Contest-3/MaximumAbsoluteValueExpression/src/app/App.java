package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().maxAbsValExpr(new int[] { 1, 2, 3, 4 }, new int[] { -1, 4, 5, 6 }));
    }

    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        // Condition1
        int cond1SumJ = 0 - arr1[0] - arr2[0];
        int cond1SumI = 0 + arr1[0] + arr2[0];

        // Condtion2
        int cond2SumJ = 0 - arr1[0] + arr2[0];
        int cond2SumI = 0 + arr1[0] - arr2[0];

        // Condition3
        int cond3SumJ = 0 + arr1[0] - arr2[0];
        int cond3SumI = 0 - arr1[0] + arr2[0];

        // Condition4
        int cond4SumJ = 0 + arr1[0] + arr2[0];
        int cond4SumI = 0 - arr1[0] - arr2[0];

        for (int i = 1; i < arr1.length; i++) {

            int condition1Sum1 = i - arr1[i] - arr2[i];
            if (condition1Sum1 > cond1SumJ) {
                cond1SumJ = condition1Sum1;
            }

            int condition1Sum2 = 0 - i + arr1[i] + arr2[i];
            if (condition1Sum2 > cond1SumI) {
                cond1SumI = condition1Sum2;
            }

            int condition2Sum1 = i - arr1[i] + arr2[i];
            if (condition2Sum1 > cond2SumJ) {
                cond2SumJ = condition2Sum1;
            }

            int condtion2Sum2 = 0 - i + arr1[i] - arr2[i];
            if (condtion2Sum2 > cond2SumI) {
                cond2SumI = condtion2Sum2;
            }

            int condition3Sum1 = i + arr1[i] - arr2[i];
            if (condition3Sum1 > cond3SumJ) {
                cond3SumJ = condition3Sum1;
            }

            int condition3Sum2 = 0 - i - arr1[i] + arr2[i];
            if (condition3Sum2 > cond3SumI) {
                cond3SumI = condition3Sum2;
            }

            int condition4Sum1 = i + arr1[i] + arr2[i];
            if (condition4Sum1 > cond4SumJ) {
                cond4SumJ = condition4Sum1;
            }

            int c4Sum2 = 0 - i - arr1[i] - arr2[i];
            if (c4Sum2 > cond4SumI) {
                cond4SumI = c4Sum2;
            }
        }

        int max1 = Math.max(cond1SumJ + cond1SumI, cond2SumJ + cond2SumI);
        int max2 = Math.max(cond3SumJ + cond3SumI, cond4SumJ + cond4SumI);

        return Math.max(max1, max2);
    }
}