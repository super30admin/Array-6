// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BuyAndSellStockAtBestTime {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = Integer.MIN_VALUE;
            int minPrice = Integer.MAX_VALUE;

            for(int i=0; i<prices.length; i++){
                if(minPrice>prices[i]){
                    minPrice= prices[i];
                }

                if(prices[i] - minPrice > maxProfit ) {
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }
    }
}
