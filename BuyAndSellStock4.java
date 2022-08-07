// Time Complexity :O(nk)
// Space Complexity :O(k) if k is smaller than n/2
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0)// we cannot make any pair
            return 0;
        if (prices.length / 2 <= k) {// we need to add all profit
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        buy[0] = prices[0];
        sell[0] = 0;// for k, we'll create array of length k and will calculate consolidated profit
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    buy[j] = Math.min(buy[j], (prices[i]));
                } else {
                    buy[j] = Math.min(buy[j], (prices[i] - sell[j - 1]));
                }
                sell[j] = Math.max(sell[j], (prices[i] - buy[j]));
            }
        }
        return sell[k - 1];
    }
}
