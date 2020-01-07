package app;

public class App {
    public static void main(String[] args) throws Exception {
        KthLargest obj = new KthLargest(2, new int[] { 0 });
        System.out.println(obj.add(-1));
        System.out.println(obj.add(1));
        System.out.println(obj.add(-2));
        // System.out.println(obj.add());
        System.out.println(obj.add(-4));
        System.out.println(obj.add(3));
    }
}