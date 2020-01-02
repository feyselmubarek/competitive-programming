package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().complexNumberMultiply("1+1i", "1+-1i"));
    }

     public String complexNumberMultiply(String a, String b) {
        int constA, constB, coofOfiA, coofOfiB;
        
        String[] arrA = a.split("\\+");
        String[] arrB = b.split("\\+");

        constA = Integer.parseInt(arrA[0]);
        coofOfiA = Integer.parseInt(arrA[1].substring(0, arrA[1].length() - 1));
        
        constB = Integer.parseInt(arrB[0]);
        coofOfiB = Integer.parseInt(arrB[1].substring(0, arrB[1].length() - 1));

        // (a + b) * (c + d) = ac + ad + bc + bd
        int ac = constA * constB;
        int ad = constA * coofOfiB;
        int bc = coofOfiA * constB;
        int bd = (coofOfiA * coofOfiB) * -1;
        
        int numberPart = ac + bd;
        int iPart = ad + bc;        

        return numberPart + "+" + iPart + "i";
    }
}