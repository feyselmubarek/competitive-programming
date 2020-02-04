package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().climbStairs(45));
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        
        return getPosibleMoves(n, memo);
    }
    
    public int getPosibleMoves(int n, int[] memoize){
        if(memoize[n] != 0){
            return memoize[n];
        }
        
        int res = getPosibleMoves(n - 1, memoize) + getPosibleMoves(n - 2, memoize);
        memoize[n] = res;
        
        return res;
    }
}