package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int equalSubstring(String s, String t, int maxCost) {
        
        int[] sumArr = new int[s.length() + 1];
        sumArr[0] = 0;
        
        for(int i = 1; i < sumArr.length; i++){
            int diff = Math.abs(s.charAt(i - 1) - t.charAt(i - 1));
            sumArr[i] = sumArr[i - 1] + diff;
        }        
        
        int max = 0, first = 0, last = 0, len = 0;
        
        while(last < sumArr.length){
            int cost = sumArr[last] - sumArr[first];
            
            if(cost <= maxCost){
                len = last - first;
                max = Math.max(len, max);
                last++;
                
            }else{                
                first++;
            }
        }
        
        return max;
    }
}