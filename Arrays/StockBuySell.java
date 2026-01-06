/*
Problem: Best Time to Buy and Sell Stock
Approach:
- Track minimum buying price so far
- Calculate profit at each step
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class StockBuySell {

    public static int stockBuy_Sell(int[] price) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            if (buy < price[i]) {
                maxProfit = Math.max(maxProfit, price[i] - buy);
            } else {
                buy = price[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + stockBuy_Sell(price));
    }
}
