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

        // adding in assending order => O(N)
        for (int i = 0; i <= howMany; i++) {
            arrayList.add(i);
        }

        // randomizing the arrayList => O(N)
        Collections.shuffle(arrayList);

        return arrayList;
    }

    public static void main(String[] args) {
        // Generating 10000 random numbers in random order
        new RandomGenerator().getRandomNumber(10000);
    }
}