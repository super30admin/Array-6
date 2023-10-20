// Time Complexity : O(n);
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;

public class BuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {

        /*int buy1 = prices[0]; int buy2 = prices[0];
        int profit1 = 0; int profit2 = 0;*/

        int buy[] = new int[k+1];
        int profit[] = new int[k+1];

        Arrays.fill(buy, Integer.MAX_VALUE);

        for(int i=0; i<prices.length; i++){

            for(int j=1; j<=k; j++)
            {
                buy[j] = Math.min(buy[j], prices[i] - profit[j-1]);
                profit[j] = Math.max(profit[j], prices[i] - buy[j]);
            }
          /*  buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - buy1);

            buy2 = Math.min(buy2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - buy2);*/
        }

        return profit[k];
    }
}