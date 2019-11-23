package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * RandomGenerator
 */
public class RandomGenerator {
    Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (arrayList.size() < 10000) {
            int number = random.nextInt(10000) + 1;
            if (!map.containsKey(number)) {
                arrayList.add(number);
                map.put(number, number);
            }
        }

        // System.out.print("[ ");
        // for (Integer integer : arrayList) {
        // System.out.print(integer + ", ");
        // }
        // System.out.print("]");
        // System.out.println();

        return arrayList;
    }
}