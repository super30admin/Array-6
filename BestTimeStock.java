// We are simply iterating over the array and maintaining a min value for buy, and then calculating the profit based on that min 
// value and updating max is the profit is greater than previous one.

// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Only 1 transaction
class Solution {
    public int maxProfit(int[] prices) {
        // Base case
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // Min will hold the buy value and max will hold the max profit
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // min of old value of min and the current stock price
            min = Math.min(min, prices[i]);
            // max of old profit and the profit obtained from sell the current stock
            max = Math.max(max, prices[i] - min);
        }
        // return ans
        return max;
    }
}