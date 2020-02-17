package app;

import java.util.ArrayList;

/**
 * ProductOfNumbers
 */
public class ProductOfNumbers {

    ArrayList<Integer> list;
    int lastZeroIndex;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        lastZeroIndex = -1;
    }

    public void add(int num) {
        if (list.size() == 0 || list.get(list.size() - 1) == 0 || num == 0) {
            list.add(num);

            if (num == 0) {
                lastZeroIndex = list.size() - 1;
            }

            return;
        }

        int len = list.size();
        list.add(num * list.get(len - 1));
    }

    public int getProduct(int k) {
        int len = list.size();

        if (k == len) {
            if (lastZeroIndex >= 0) {
                return 0;
            } else {
                return list.get(len - 1);
            }
        } else {
            int prevIndex = len - k - 1;
            if (lastZeroIndex > prevIndex) {
                return 0;
            }

            int total = list.get(len - 1);
            if (list.get(prevIndex) == 0) {
                return total;
            }

            return total / list.get(prevIndex);
        }
    }
}