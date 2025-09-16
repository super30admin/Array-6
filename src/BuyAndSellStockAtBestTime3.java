//time complexity- O(n)
//space complexity- o(1)
import java.util.*;
public class BuyAndSellStockAtBestTime3 {
    static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = prices[0], buy2 = prices[0];
        int sell1 = 0, sell2 = 0;
        for(int i=1; i<n; i++){
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Prices: "+ Arrays.toString(prices));
        System.out.println("Maximum Profit: "+ maxProfit(prices));
    }
}
