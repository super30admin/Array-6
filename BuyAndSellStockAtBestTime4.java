// Time Complexity : O(N.k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BuyAndSellStockAtBestTime4 {
    class Solution {
        public int maxProfit(int k, int[] prices) {

            if(k == 0) return 0;

            if(k >= prices.length / 2) {
                int profit = 0;

                for(int i=1; i< prices.length; i++) {
                    if(prices[i] > prices[i-1]) {
                        profit += prices[i] - prices[i-1];
                    }
                }

                return profit;
            }

            int[] buy = new int[k];
            int[] profit = new int[k];
            Arrays.fill(buy, Integer.MAX_VALUE);
            for(int i=0; i< prices.length; i++) {
                for(int j=0; j<k; j++) {
                    if(j == 0) {
                        buy[j] = Math.min(buy[j], prices[i]);
                    } else {
                        buy[j] = Math.min(buy[j], prices[i] - profit[j-1]);
                    }
                    profit[j] = Math.max(profit[j], prices[i] - buy[j]);
                }
            }

            return profit[k-1];
        }
    }
}
