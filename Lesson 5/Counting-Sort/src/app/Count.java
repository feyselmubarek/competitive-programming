package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Count {
    public ArrayList<Integer> performCountingSort(ArrayList<Integer> arrayList) {
        // arraylist for returning result
        ArrayList<Integer> result = new ArrayList<>();

        // arraylist for mapping occurance of each given array element
        Map<Integer, Integer> occ = new HashMap<>();

        // counting occurance an mapping it to occ map the hashing algorithm makes them
        // inserted by sorted order
        for (int i = 0; i < arrayList.size(); i++) {
            int num = arrayList.get(i);
            if (occ.containsKey(num)) {
                occ.put(num, occ.get(num) + 1);
            } else {
                occ.put(num, 1);
            }
        }

        // calculating how many element are before each mapped element
        int sum = 0;
        for (int i : occ.keySet()) {
            sum += occ.get(i);
            occ.put(i, sum);
        }

        // populating the result arraylist based on thier degree of occurance
        int c = 0;
        for (int i : occ.keySet()) {
            while (c < occ.get(i)) {
                result.add(i);
                c++;
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + ", ");
        }

        return result;
    }
}