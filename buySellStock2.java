// Time Complexity : O(n) where n is the length of the array prices
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class buySellStock2 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}