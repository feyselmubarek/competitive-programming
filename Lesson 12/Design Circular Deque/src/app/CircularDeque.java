package app;

import java.util.ArrayList;

public class CircularDeque {

    ArrayList<Integer> deque;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {
        deque = new ArrayList<>();
        size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            deque.add(0, value);
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            deque.add(value);
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            deque.remove(0);
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            deque.remove(deque.size() - 1);
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (!isEmpty()) {
            return deque.get(0);
        }
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (!isEmpty()) {
            return deque.get(deque.size() - 1);
        }
        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.size() == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return deque.size() == size;
    }

}