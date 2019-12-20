package app;

public class Solution extends VersionControl {
    public Solution() {
        super();
    }

    public int firstBadVersion(int n) {
        if (isBadVersion(0)) {
            return 1;
        }
        int current = n / 2;

        while ((n - current) > 1) {
            boolean val = isBadVersion(current);
            if (val) {
                n = current;
                current = n / 2;
            } else {
                current = ((n - current) / 2) + current;
            }
        }

        if (isBadVersion(n) && !isBadVersion(current)) {
            return n;
        }

        return current;
    }
}