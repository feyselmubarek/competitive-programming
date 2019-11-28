import java.util.ArrayList;
import java.util.Collections;
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

        for (int i = 0; i <= howMany; i++) {
            arrayList.add(i);
        }

        Collections.shuffle(arrayList);

        return arrayList;
    }

    public static void main(String[] args) {
        new RandomGenerator().getRandomNumber(10000);
    }
}