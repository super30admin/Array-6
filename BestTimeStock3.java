// Similar approach, here at most we can do two transactions. So we will keep 2 pairs of buy and sell value. Here we are using the logic
// that if we otained some profit from the first transaction then we will use that to bring the buy value down for the next transaction.
// So we will get the cumulative profit in sell2.

// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int maxProfit(int[] prices) {
        // Base
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 4 variables
        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            // Simply min of buy1 and current stock price
            buy1 = Math.min(buy1, prices[i]);
            // max of old profit and profit obtained from selling current stock
            sell1 = Math.max(sell1, prices[i] - buy1);
            // min of old buy2 and buy price after deducting the profit earned in last
            // transaction
            buy2 = Math.min(buy2, prices[i] - sell1);
            // Max of old and profit obtained by selling current stock
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
}