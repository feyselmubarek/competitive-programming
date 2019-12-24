package app;

public class MyCircularQueue {
    public int[] queue;
    public int front, last, capacity, length;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        last = 0;
        length = 0;
        capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (!isFull()) {
            if (isEmpty()) {
                queue[last] = value;
            } else {
                last = (last + 1) % capacity;
                queue[last] = value;
            }
            length++;
            return true;
        }
        return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (!isEmpty()) {
            if (length != 1) {
                front = (front + 1) % capacity;
            }
            length--;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (!isEmpty()) {
            return queue[front];
        }

        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (!isEmpty()) {
            return queue[last];
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return length == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return length == capacity;
    }
}
