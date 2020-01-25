package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int currentOptimal = 0;
        int lastPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (lastPrice < prices[i]) {
                currentOptimal += prices[i] - lastPrice;
            } else {
                if (currentOptimal > maxProfit) {
                    maxProfit += currentOptimal;
                    currentOptimal = 0;
                }
            }

            lastPrice = prices[i];
        }

        return currentOptimal > 0 ? maxProfit + currentOptimal : maxProfit;
    }
}