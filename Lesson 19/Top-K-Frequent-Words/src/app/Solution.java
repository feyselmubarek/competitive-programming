package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> occuranceMap = new HashMap<String, Integer>();

        for (int last = 0; last < words.length; last++) {
            occuranceMap.put(words[last],
                    occuranceMap.containsKey(words[last]) ? occuranceMap.get(words[last]) + 1 : 1);
        }

        PriorityQueue<Word> minHeap = new PriorityQueue<>(k);

        for (String w : occuranceMap.keySet()) {
            Word word = new Word(w, occuranceMap.get(w));

            if (minHeap.size() < k) {
                minHeap.add(word);
            } else {
                if (minHeap.peek().compareTo(word) < 0) {
                    minHeap.poll();
                    minHeap.add(word);
                }
            }
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add(minHeap.poll().title);
        }

        Collections.reverse(list);

        return list;
    }
}

class Word implements Comparable<Word> {
    public String title;
    public int occurance;

    public Word(String title, int occurance) {
        this.title = title;
        this.occurance = occurance;
    }

    @Override
    public int compareTo(Word o) {
        if (this.occurance > o.occurance || (this.occurance == o.occurance && (this.title.compareTo(o.title) < 0))) {
            return 1;
        }

        return -1;
    }
}