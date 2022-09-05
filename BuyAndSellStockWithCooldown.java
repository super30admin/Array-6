// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BuyAndSellStockWithCooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <= 1) return 0;
            int [] buyProfit = new int [prices.length];
            int [] sellProfit = new int [prices.length];
            buyProfit[0] = -prices[0];
            buyProfit[1] = Math.max(-prices[0], -prices[1]);
            sellProfit[1] = Math.max(sellProfit[0], buyProfit[0] + prices[1]);

            for(int i = 2; i < prices.length; i++){
                buyProfit[i] = Math.max(buyProfit[i - 1], sellProfit[i - 2] - prices[i]);
                sellProfit[i] = Math.max(sellProfit[i - 1], buyProfit[i - 1] + prices[i]);
            }

            return sellProfit[prices.length - 1];
        }
    }
}
