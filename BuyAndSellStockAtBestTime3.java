// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BuyAndSellStockAtBestTime3 {
    class Solution {
        public int maxProfit(int[] prices) {
            //best single transaction irrespective of one or two transaction are done
            int buy1 = prices[0]; // min buying price
            int profit = 0;
            //consolidated transaction irrespective of one or two transaction are done
            int estBuy2 = prices[0] - profit;
            int consolidatedProfit = prices[0] - estBuy2;

            for(int i=1; i<prices.length; i++) {
                buy1 = Math.min(buy1, prices[i]);
                profit = Math.max(profit, prices[i] - buy1);
                estBuy2 = Math.min(estBuy2, prices[i] - profit);
                consolidatedProfit = Math.max(consolidatedProfit, prices[i] - estBuy2);
            }

            return consolidatedProfit;
        }
    }
}
