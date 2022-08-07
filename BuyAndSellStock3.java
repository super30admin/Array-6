// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int sell1 = 0;
        int buy2 = (prices[0] - sell1);
        int sell2 = prices[0] - buy2;

        for (int i = 1; i < prices.length; i++) {
            // buy2 means second buy-first profit
            buy2 = Math.min(buy2, (prices[i] - sell1));
            // sell2 means consolidated maximum profit
            sell2 = Math.max(sell2, (prices[i] - buy2));
            // maximum first buy
            buy1 = Math.min(buy1, prices[i]);
            // maximum first sell
            sell1 = Math.max(sell1, (prices[i] - buy1));
        }
        return sell2;
    }
}
