package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return nums[0];
        }
        
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        nums[2] += nums[0];
        
        for(int i = 3; i < nums.length; i++){
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }
        
        return Math.max(nums[n - 1], nums[n - 2]);
    }
}