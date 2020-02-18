package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int maxPos = nums[0];
        int minNeg = nums[0];
        int maxProd = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int possibleMax = Integer.MIN_VALUE;
            int possibleMin = Integer.MAX_VALUE;
            
            if(maxPos * nums[i] >= maxPos){
                if(maxPos == 0){
                    maxPos = nums[i];
                }else{
                    maxPos = Math.max(maxPos * nums[i], nums[i]);
                }
            }else{
                possibleMin = maxPos * nums[i];
                maxPos = nums[i]; 
            }
            
            if(minNeg * nums[i] <= minNeg){
                if(minNeg == 0){
                    minNeg = nums[i];
                }else{
                    minNeg = Math.min(minNeg * nums[i], nums[i]);
                }
            }else{
                possibleMax = minNeg * nums[i];
                minNeg = nums[i];
            }
            
            maxPos = Math.max(maxPos, possibleMax);
            minNeg = Math.min(minNeg, possibleMin);
            
            maxProd = Math.max(maxProd, maxPos);            
            maxProd = Math.max(maxProd, minNeg);
        }
        
        
        return maxProd;
    }
}