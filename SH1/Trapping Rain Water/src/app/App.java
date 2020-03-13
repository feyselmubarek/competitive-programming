package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        populateLeftMax(leftMax, height);
        populateRightMax(rightMax, height);
        
        int trappedWater = 0;
        
        for(int index = 0; index < height.length; index++){
            trappedWater += Math.min(leftMax[index], rightMax[index]) - height[index];
        }
        
        return trappedWater;
    }
    
    public void populateRightMax(int[] rightMax, int[] height){
        int rMax = -1;
        
        for(int index = height.length - 1; index >= 0; index--){
            rMax = Math.max(rMax, height[index]);
            rightMax[index] = rMax;
        }
    }
    
    public void populateLeftMax(int[] leftMax, int[] height){
        int lMax = -1;
        
        for(int index = 0; index < height.length; index++){
            lMax = Math.max(lMax, height[index]);
            leftMax[index] = lMax;
        }
    }
}
