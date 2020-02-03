package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().isMonotonic(new int[] { 1, 2, 2, 2 }));
    }

    public boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }

        int holder = A[0];
        boolean inc = false, iden = false;

        for (int i = 1; i < A.length; i++) {
            if (holder != A[i]) {
                if (!iden) {
                    iden = true;
                    if (holder < A[i]) {
                        inc = true;
                    } else {
                        inc = false;
                    }
                } else {
                    if (inc) {
                        if (holder > A[i]) {
                            return false;
                        }
                    } else {
                        if (holder < A[i]) {
                            return false;
                        }
                    }
                }
            }
            holder = A[i];
        }

        return true;
    }
}