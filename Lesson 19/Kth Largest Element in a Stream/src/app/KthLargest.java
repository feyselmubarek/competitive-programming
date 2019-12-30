// question link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
package app;

public class KthLargest {
    int k, kthLargestNumber, noOfRemainingElement;
    int[] maxHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        noOfRemainingElement = k;
        maxHeap = new int[k > nums.length ? k : nums.length];

        for (int i = 0; i < nums.length; i++) {
            maxHeap[i] = nums[i];
            noOfRemainingElement--;
        }

        kthLargestNumber = getKthLargestNumber(maxHeap);
    }

    private int getKthLargestNumber(int[] maxHeap) {
        int counterUntilK = 0, kthNumber = 0;

        while (counterUntilK < k) {
            int currentLastIndex = (maxHeap.length - 1) - counterUntilK;
            heapify(maxHeap, 0, currentLastIndex, currentLastIndex + 1);

            int currntMax = maxHeap[0];
            maxHeap[0] = maxHeap[currentLastIndex];
            maxHeap[currentLastIndex] = currntMax;

            kthNumber = currntMax;
            counterUntilK++;
        }

        return kthNumber;
    }

    public int add(int val) {
        if (noOfRemainingElement > 0) {
            maxHeap[maxHeap.length - 1] = val;
            kthLargestNumber = getKthLargestNumber(maxHeap);
            noOfRemainingElement--;

            return kthLargestNumber;
        }

        if (val <= kthLargestNumber)
            return kthLargestNumber;

        int index = maxHeap.length - (k + 1) < 0 ? 0 : maxHeap.length - (k + 1);
        maxHeap[index] = val;
        kthLargestNumber = getKthLargestNumber(maxHeap);

        return kthLargestNumber;
    }

    public void heapify(int[] heap, int first, int last, int length) {
        for (int i = last; i >= first; i--) {
            int leftChildIndex = (2 * i) + 1, rightChildIndex = (2 * i) + 2;
            int current = i;

            if (rightChildIndex < length && heap[rightChildIndex] > heap[current])
                current = rightChildIndex;

            if (leftChildIndex < length && heap[leftChildIndex] > heap[current])
                current = leftChildIndex;

            if (current != i) {
                int temp = heap[i];
                heap[i] = heap[current];
                heap[current] = temp;

                heapify(heap, current, last, length);
            }
        }
    }
}

// ["KthLargest","add","add","add","add","add"]
// [[2,[0]],[-1],[1],[-2],[-4],[3]]

// ["KthLargest","add","add","add","add","add"]
// [[2,[0]],[-1],[1],[-2],[-4],[3]]