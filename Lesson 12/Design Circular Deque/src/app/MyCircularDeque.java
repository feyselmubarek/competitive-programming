package app;

public class MyCircularDeque {
    private int[] deque;
    private int front, last, mod;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        last = k - 1;
        mod = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            deque[front] = value;
            front = (front + 1) % mod;
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
            deque[last] = value;
            last = (last - 1) % mod;
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
            deque[front] = -1;
            front = (front - 1) % mod;
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
            deque[last] = -1;
            last = (last + 1) % mod;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (!isEmpty()) {
            return deque[front - 1];
        }
        return 0;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (!isEmpty()) {
            return deque[last + 1];
        }
        return 0;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front - last == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return front > last;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */