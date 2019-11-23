package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> integers = performMergeSort(new RandomGenerator().getRandomNumber(10000));

        System.out.println();
        System.out.print("[ ");
        for (Integer integer : integers) {
            System.out.print(integer + ", ");
        }
        System.out.print("]");
        System.out.println();

    }

    public static ArrayList<Integer> performMergeSort(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1) {
            return arrayList;
        } else {
            ArrayList<Integer> bothSide = new ArrayList<>();
            int halfIndex = (arrayList.size() % 2 == 0) ? (arrayList.size() / 2) : (arrayList.size() / 2 + 1);

            ArrayList<Integer> leftSide = new ArrayList<>(arrayList.subList(0, halfIndex));
            leftSide = performMergeSort(leftSide);

            ArrayList<Integer> rightSide = new ArrayList<>(arrayList.subList(halfIndex, arrayList.size()));
            rightSide = performMergeSort(rightSide);

            int i = 0, j = 0;

            while ((i < leftSide.size()) || (j < rightSide.size())) {
                try {
                    if (leftSide.get(i) < rightSide.get(j)) {
                        bothSide.add(leftSide.get(i));
                        i++;
                    } else {
                        bothSide.add(rightSide.get(j));
                        j++;
                    }
                } catch (Exception e) {
                    if (i == leftSide.size()) {
                        bothSide.addAll(rightSide.subList(j, rightSide.size()));
                        break;
                    } else if (j == rightSide.size()) {
                        bothSide.addAll(leftSide.subList(i, leftSide.size()));
                        break;
                    }
                }
            }
            return bothSide;
        }
    }
}