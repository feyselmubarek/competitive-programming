package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> occuranceMap = new HashMap<String, Integer>();

        for (int last = 0; last < words.length; last++) {
            if (occuranceMap.containsKey(words[last]))
                occuranceMap.put(words[last], occuranceMap.get(words[last]) + 1);
            else
                occuranceMap.put(words[last], 1);
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(occuranceMap.size(), (a, b) -> (b.y - a.y));
        PriorityQueue<String> secondPriorityQueue = new PriorityQueue<String>((a, b) -> (a.compareTo(b)));

        for (String last : occuranceMap.keySet())
            priorityQueue.add(new Pair(last, occuranceMap.get(last)));

        List<String> result = new ArrayList<>();
        Pair top = priorityQueue.remove();
        int curOcuVal = top.y;

        for (int i = 0; i < k;) {
            while (curOcuVal == top.y) {
                secondPriorityQueue.add(top.x);
                curOcuVal = top.y;

                top = priorityQueue.remove();
            }

            while (i < k && secondPriorityQueue.size() != 0) {
                result.add(secondPriorityQueue.remove());
                i++;
            }

            curOcuVal = top.y;
        }

        return result;
    }
}

class Pair {
    // x represents word, y is occurance
    public String x;
    public int y;

    public Pair(String x, int y) {
        this.x = x;
        this.y = y;
    }
}