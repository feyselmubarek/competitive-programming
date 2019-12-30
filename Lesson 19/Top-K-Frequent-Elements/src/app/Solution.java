package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();

        for (int last = 0; last < nums.length; last++) {
            if (occuranceMap.containsKey(nums[last]))
                occuranceMap.put(nums[last], occuranceMap.get(nums[last]) + 1);
            else
                occuranceMap.put(nums[last], 1);
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(occuranceMap.size(), (a, b) -> (b.y - a.y));

        for (int last : occuranceMap.keySet())
            priorityQueue.add(new Pair(last, occuranceMap.get(last)));

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Pair top = priorityQueue.remove();
            result.add(top.x);
        }

        return result;
    }
}

class MyPriorityQueue {
    Pair[] queue;
    int length;

    public MyPriorityQueue(int size) {
        queue = new Pair[size];
        length = 0;
    }

    public boolean insertWithPriority(Pair pair) {
        if (length < queue.length) {
            queue[length] = pair;

            int last = length;

            while ((last / 2) >= 0) {
                Pair parentYVal = queue[last / 2];

                if (parentYVal.y >= pair.y)
                    break;

                Pair temp = queue[last];
                queue[last] = parentYVal;
                queue[last / 2] = temp;

                last /= 2;
            }
            length++;
            return true;
        }
        return false;
    }

    public Pair pullHighestPriority() {
        Pair top = queue[0];
        length--;

        queue[0] = queue[length];
        queue[length] = top;

        bubbleDown(queue, 0, length);
        return top;
    }

    public void bubbleDown(Pair[] heap, int last, int length) {
        int current = last, leftChildIndex = (2 * last) + 1, rightChildIndex = (2 * last) + 2;

        if (rightChildIndex < length && heap[rightChildIndex].y > heap[current].y)
            current = rightChildIndex;

        if (leftChildIndex < length && heap[leftChildIndex].y > heap[current].y)
            current = leftChildIndex;

        if (current != last) {
            Pair temp = heap[last];
            heap[last] = heap[current];
            heap[current] = temp;

            bubbleDown(heap, current, length);
        }
    }
}

class Pair {
    // x represents numbers, y is occurance
    public int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}