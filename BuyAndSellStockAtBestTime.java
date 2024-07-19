// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class BuyAndSellStockAtBestTime {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }
}