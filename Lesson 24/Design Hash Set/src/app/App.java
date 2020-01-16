package app;

public class App {
    public static void main(String[] args) throws Exception {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(2);
        myHashSet.add(1);
        myHashSet.add(6);
        System.out.println(myHashSet.contains(3));
    }
}