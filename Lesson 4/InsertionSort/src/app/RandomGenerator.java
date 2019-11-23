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

    public ArrayList<Integer> getRandomNumber(int howMany) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (arrayList.size() < howMany) {
            int number = random.nextInt(howMany);
            if (!map.containsKey(number)) {
                arrayList.add(number);
                map.put(number, number);
            }
        }

        return arrayList;
    }
}