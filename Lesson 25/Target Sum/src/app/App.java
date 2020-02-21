package app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int findTargetSumWays(int[] nums, int S) {
        HashMap<State, Integer> memo = new HashMap<>();
        
        int leftPossibility = dfs(memo, nums, 0, S + nums[0]);
        int rightPossibility = dfs(memo, nums, 0, S - nums[0]);
        
        return leftPossibility + rightPossibility;
    }
    
    public int dfs(HashMap<State, Integer> memo, int[] nums, int index ,int target){
        State state = new State(index, target);
        
        if(!memo.containsKey(state)){
            if(index == nums.length - 1){
                int val = 0;
                
                if(target == 0){
                    val = 1;    
                }
                
                memo.put(state, val);
                return val;
            }
            
            // left 
            int pathCount = dfs(memo, nums, index + 1, target + nums[index + 1]);
            
            // right
            pathCount += dfs(memo, nums, index + 1, target - nums[index + 1]);
            
            memo.put(state, pathCount);
        }
        
        return memo.get(state);
    }
}

class State {
    public int index;
    public int target;
    
    public State(int index, int target){
        this.index = index;
        this.target = target;
    }
    
    @Override
    public int hashCode(){
        return (index + target) * (index + 17);
    }
    
    @Override
    public boolean equals(Object obj){
        State st = (State) obj;
        return st.index == this.index && st.target == this.target;
    }
}