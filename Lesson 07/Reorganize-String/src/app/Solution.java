package app;

public class Solution {

    public String reorganizeString(String S) {
        int[] lettersOccur = new int[26];

        for (int i = 0; i < S.length(); i++) {
            lettersOccur[(int) S.charAt(i) - 97] += 1;
        }

        StringBuilder stringBuilder = new StringBuilder(S);
        int maxIndex = getMaxIndexWithoutCurrent(lettersOccur, ((int)'A'));

        for (int i = 0; i < S.length(); i++) {
            stringBuilder.setCharAt(i, (char)(maxIndex + 97));
            int curMaxIndex = getMaxIndexWithoutCurrent(lettersOccur, maxIndex);
    
            if (curMaxIndex == maxIndex && i != S.length() - 1) {
                return "";    
            }
            
            maxIndex = curMaxIndex;
        }

        return stringBuilder.toString();
    }

    public int getMaxIndexWithoutCurrent(int[] list, int current) {
        int max = 0, index = current;

        for (int i = 0; i < list.length; i++) {
            if (list[i] >= max && i != current && list[i] != 0) {
                max = list[i];
                index = i;
            }
        }

        list[index] = list[index] - 1;

        return index;
    }

}