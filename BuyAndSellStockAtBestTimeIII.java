// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class BuyAndSellStockAtBestTimeIII {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0], buy2 = prices[0];
        int sell1 = 0, sell2 = 0;

        for(int i = 1; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i]-buy1);

            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i]-buy2);
        }
        return sell2;
    }
}