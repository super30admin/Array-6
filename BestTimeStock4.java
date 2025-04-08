// Similar approach as in stock3, but here we can do at most k transacrtions. So we will maintain k pairs of buy and sell.

// Time Complexity : O(nk) 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int[] sell = new int[k];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    buy[j] = Math.min(buy[j], prices[i]);
                } else {
                    buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                }
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k - 1];
    }
}