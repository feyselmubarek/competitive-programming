package app;

public class App {
    public static void main(String[] args) throws Exception {
        MyHashMap map = new MyHashMap();
        map.put(1, 2);
        map.put(3, 10);
        map.put(5, 89);
        System.out.println(map.get(5));
    }
}