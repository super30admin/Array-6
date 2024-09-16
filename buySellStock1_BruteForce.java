// Time Complexity : O(n^2) where n is the length of the array prices
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class buySellStock1_BruteForce {
    public int maxProfit(int[] prices) {
        int max = 0, n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}