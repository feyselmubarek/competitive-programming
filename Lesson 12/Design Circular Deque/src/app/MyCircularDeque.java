package app;

// uncompleted version
public class MyCircularDeque {
    public int[] deque;
    public int front, last, capacity, length;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        last = 0;
        length = 0;
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            if (isEmpty()) {
                deque[front] = value;
            } else {
                front = (front + 1) % capacity;
                deque[front] = value;
            }
            length++;
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
            if (isEmpty()) {
                deque[last] = value;
            } else {
                last = last == 0 ? capacity - 1 : Math.abs((last - 1) % capacity);
                deque[last] = value;
            }
            length++;
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
            if (length != 1) {
                front = front == 0 ? capacity - 1 : Math.abs((front - 1) % capacity);
            }
            length--;
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
            if (length != 1) {
                last = (last + 1) % capacity;
            }
            length--;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (!isEmpty()) {
            return deque[front];
        }
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (!isEmpty()) {
            return deque[last];
        }
        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return length == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return length == capacity;
    }
}