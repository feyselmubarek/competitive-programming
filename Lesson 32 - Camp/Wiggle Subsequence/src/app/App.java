package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        boolean isFound = false, wasIncreasing = false;
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (!isFound && nums[i] != nums[i - 1]) {
                isFound = true;

                if (nums[i - 1] < nums[i]) {
                    wasIncreasing = true;
                }

                len++;

                continue;
            }

            if ((nums[i - 1] < nums[i] && !wasIncreasing) || (nums[i - 1] > nums[i] && wasIncreasing)) {
                len++;
                wasIncreasing = !wasIncreasing;
            }
        }

        return len;
    }
}