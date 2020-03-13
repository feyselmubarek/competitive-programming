package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int pivotIndex = getPivotIndex(nums);
        int start = 0;
        int end = nums.length - 1;

        if (target >= nums[start] && target <= nums[pivotIndex]) {
            return findElement(nums, start, pivotIndex, target);
        } else if (pivotIndex + 1 < nums.length && target >= nums[pivotIndex + 1] && target <= nums[end]) {
            return findElement(nums, pivotIndex + 1, end, target);
        }

        return -1;
    }

    public int findElement(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start == end ? start : (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int getPivotIndex(int[] A) {
        int l = 0;
        int r = A.length - 1;

        while (l + 1 < r) {
            int m = (l + r) / 2;

            if (A[l] < A[m]) {
                l = m;
            } else if (A[m] < A[r]) {
                r = m;
            }
        }

        return l;
    }
}