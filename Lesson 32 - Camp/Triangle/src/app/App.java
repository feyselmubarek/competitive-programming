package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

     public int minimumTotal(List<List<Integer>> triangle) {        
        for(int i = triangle.size()- 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int bottom = triangle.get(i + 1).get(j);
                int right = triangle.get(i + 1).get(j + 1);
                int current = triangle.get(i).get(j);
                
                triangle.get(i).set(j, Math.min(bottom, right) + current);                
            }
        }
        
        return triangle.get(0).get(0);
    }
}