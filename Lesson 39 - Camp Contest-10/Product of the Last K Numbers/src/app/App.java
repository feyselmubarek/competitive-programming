package app;

public class App {
    public static void main(String[] args) throws Exception {
        ProductOfNumbers p = new ProductOfNumbers();
        p.add(3);
        p.add(0);
        p.add(2);
        p.add(5);
        p.add(4);

        System.out.println(p.getProduct(1));
        System.out.println(p.getProduct(2));
        System.out.println(p.getProduct(3));
        System.out.println(p.getProduct(4));
        System.out.println(p.getProduct(5));
    }
}