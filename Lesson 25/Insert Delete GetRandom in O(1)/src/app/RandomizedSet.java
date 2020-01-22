package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);

            return true;
        }

        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastIndex = list.size() - 1;

            Collections.swap(list, index, lastIndex);

            map.remove(val);
            list.remove(lastIndex);

            if (list.size() != index) {
                map.put(list.get(index), index);
            }

            return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}