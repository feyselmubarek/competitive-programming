// question link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
package app;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int capacity;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>(k);
        capacity = k;

        for (int i = 0; i < nums.length; i++) {
            insertIntoMinHeap(nums[i]);
        }
    }

    public int add(int val) {
        if (minHeap.size() == capacity) {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }

            return minHeap.peek();
        }

        minHeap.add(val);
        return minHeap.peek();
    }

    public void insertIntoMinHeap(int val) {
        if (minHeap.size() == capacity) {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        } else {
            minHeap.add(val);
        }
    }
}

// ["KthLargest","add","add","add","add","add"]
// [[2,[0]],[-1],[1],[-2],[-4],[3]]

// ["KthLargest","add","add","add","add","add"]
// [[2,[0]],[-1],[1],[-2],[-4],[3]]