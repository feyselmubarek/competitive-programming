package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        RandomGenerator generator = new RandomGenerator();
        performSelectionSort(generator.getRandomNumber());
    }

    public static void performSelectionSort(ArrayList<Integer> arrayList) {
        int currentMin, min = arrayList.get(0), index = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            currentMin = arrayList.get(i);
            min = currentMin;

            for (int j = i + 1; j < arrayList.size(); j++) {
                if (currentMin > arrayList.get(j)) {
                    currentMin = arrayList.get(j);
                    index = j;
                }
            }

            if (min != currentMin) {
                arrayList.remove(index);
                arrayList.add(index, min);

                arrayList.remove(i);
                arrayList.add(i, currentMin);
            }
        }

        System.out.print("[ ");
        for (Integer integer : arrayList) {
            System.out.print(integer + ", ");
        }
        System.out.print("]");
        System.out.println();

    }
}