// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BuyAndSellStockAtBestTime2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int totalProfit = 0;
            for(int i=1; i<prices.length; i++) {
                if(prices[i] > prices[i-1]) {
                    totalProfit += prices[i] - prices[i-1];
                }
            }

            return totalProfit;
        }
    }
}
