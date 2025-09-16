//time complexity- O(n)
//space complexity- o(1)
import java.util.*;
public class BuyAndSellStockAtBestTime {
    static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;

        for(int i = 1; i < n; i++) {
            profit = Math.max(profit, prices[i] - buy);
            buy =  Math.min(buy, prices[i]);
        }

        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Prices: "+ Arrays.toString(prices));
        System.out.println("Maximum Profit: "+ maxProfit(prices));
    }
}
