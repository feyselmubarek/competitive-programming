package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();

        for (int first = 0; first < nums.length; first++) {
            if (occuranceMap.containsKey(nums[first])) {
                occuranceMap.put(nums[first], occuranceMap.get(nums[first]) + 1);
            } else {
                occuranceMap.put(nums[first], 1);
            }
        }

        MyPriorityQueue priorityQueue = new MyPriorityQueue(occuranceMap.size());

        for (int first : occuranceMap.keySet()) {
            priorityQueue.insertWithPriority(new Pair(first, occuranceMap.get(first)));
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Pair top = priorityQueue.pullHighestPriority();
            result.add(top.number);
        }

        return result;
    }
}

class MyPriorityQueue {
    Pair[] maxHeap;
    int length;

    public MyPriorityQueue(int size) {
        maxHeap = new Pair[size];
        length = 0;
    }

    public boolean insertWithPriority(Pair pair) {
        if (length < maxHeap.length) {
            maxHeap[length] = pair;

            int last = length;

            while (((last - 1) / 2) >= 0) {
                Pair parentYVal = maxHeap[(last - 1) / 2];

                if (parentYVal.occurance >= pair.occurance) {
                    break;
                }

                Pair temp = maxHeap[last];
                maxHeap[last] = parentYVal;
                maxHeap[(last - 1) / 2] = temp;

                last = (last - 1) / 2;
            }
            length++;
            return true;
        }
        return false;
    }

    public Pair pullHighestPriority() {
        Pair top = maxHeap[0];
        length--;

        maxHeap[0] = maxHeap[length];
        maxHeap[length] = top;

        bubbleDown(0, length);

        return top;
    }

    public void bubbleDown(int first, int length) {
        int largest = first, leftChildIndex = (2 * first) + 1, rightChildIndex = (2 * first) + 2;

        if (rightChildIndex < length && maxHeap[rightChildIndex].occurance > maxHeap[largest].occurance) {
            largest = rightChildIndex;
        }

        if (leftChildIndex < length && maxHeap[leftChildIndex].occurance > maxHeap[largest].occurance) {
            largest = leftChildIndex;
        }

        if (largest != first) {
            Pair temp = maxHeap[first];
            maxHeap[first] = maxHeap[largest];
            maxHeap[largest] = temp;

            bubbleDown(largest, length);
        }
    }
}

class Pair {
    public int number, occurance;

    public Pair(int number, int occurance) {
        this.number = number;
        this.occurance = occurance;
    }
}