package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int findLength(int[] A, int[] B) {
        int[][] memo = new int[A.length][];
        int maxLength = 0;
        
        for(int i = 0; i < memo.length; i++){
            memo[i] = new int[B.length];
            
            for(int j = 0; j < memo[i].length; j++){
                int val = 0;
                
                if(A[i] == B[j]){
                    
                    if(i == 0 || j == 0){
                        val = 1;
                    }else{
                        val = memo[i - 1][j - 1] + 1;
                    }
                    
                    memo[i][j] = val;
                    maxLength = Math.max(maxLength, val);
                } else {
                    memo[i][j] = 0;   
                }                
                
            }
        }
        
        
        return maxLength;
    }
}