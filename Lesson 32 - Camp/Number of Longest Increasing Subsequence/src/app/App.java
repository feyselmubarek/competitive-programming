package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int findNumberOfLIS(int[] nums) {     
        int n = nums.length;
        int max = 0, maxCount = 0;
        
        Pair[] memo = new Pair[n];
        
        
        for(int i = n - 1; i >= 0; i--){
            max = 0;
            maxCount = 0;
            
            for(int j = i + 1; j < n; j++){
                if(nums[i] < nums[j]){
                    if(memo[j].len > max){
                        max = memo[j].len;
                        maxCount = memo[j].occ;
                    }else if(memo[j].len == max){
                        maxCount += memo[j].occ;
                    }
                }
            }
            
            memo[i] = new Pair(max + 1, maxCount == 0 ? 1: maxCount);
        }
        
        int maxLen = 0, occurance = 0;
        for(Pair p : memo){
            if(p.len == maxLen){
                occurance += p.occ;
            }else if(p.len > maxLen){
                maxLen = p.len;
                occurance = p.occ;
            }
        }
        
        
        return occurance;
    }
}

class Pair{
    int len;
    int occ;
    
    public Pair(int len, int occ){
        this.len = len;
        this.occ = occ;
    }
}