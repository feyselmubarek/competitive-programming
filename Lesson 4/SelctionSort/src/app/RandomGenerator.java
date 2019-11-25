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
        Set<Integer> set = new HashSet<>();

        while (arrayList.size() < howMany) {
            int number = random.nextInt(howMany) + 1;
            if (!set.contains(number)) {
                arrayList.add(number);
                set.add(number);
            }
        }

        return arrayList;
    }
}