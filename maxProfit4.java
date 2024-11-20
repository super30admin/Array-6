// 188. Best Time to Buy and Sell Stock IV
// Time Complexity : O(kn)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        
        return sell[k];
    }
}