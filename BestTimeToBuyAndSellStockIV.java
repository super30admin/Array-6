// TC: O(nk)
// SC: O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(nk), SC = O(k)
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < k; j++) {
                if(j == 0) {
                    buy[j] = Math.min(buy[j], prices[i]); // prices[i] & not prices[0], to see if the current day's price is better for buying.
                }
                else {
                    buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                }
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k - 1];
    }
}