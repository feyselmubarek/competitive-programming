package app;

import java.util.Arrays;

class MyHashSet {
    int[] set;

    /** Initialize your data structure here. */
    // direct indexing approach
    public MyHashSet() {
        set = new int[1000001];
        Arrays.fill(set, 0, 1000000, -1);
    }

    public void add(int key) {
        if (set[key] == -1) {
            set[key] = key;
        }
    }

    public void remove(int key) {
        set[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key] != -1;
    }
}
