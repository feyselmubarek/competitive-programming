package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int minDeletionSize(String[] A) {
        if(A.length == 0){
            return 0;
        }
        
        String holder = A[0];
        boolean[] isDeleted = new boolean[A[0].length()];
        int removal = 0;
        
        for(int i = 1; i < A.length; i++){
            String current = A[i];
            
            for(int j = 0; j < current.length(); j++){
                if(!isDeleted[j]){
                    if(current.charAt(j) < holder.charAt(j)){
                        isDeleted[j] = true;
                        removal++;
                    }
                }
            }
            
            holder = current;
        }
        
        return removal;
    }
}