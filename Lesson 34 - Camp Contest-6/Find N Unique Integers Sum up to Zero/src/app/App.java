package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int[] sumZero(int n) {
        int[] res = new int[n];
        int counter = 0;
        
        for(int i = 1; i <= n / 2; i++){            
            res[counter] = i;
            counter++;
            
            res[counter] = -1 * i;
            counter++;
        }
        
        return res;
    }
}