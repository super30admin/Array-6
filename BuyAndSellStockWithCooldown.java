// Time Complexity = O(n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// We use DP to solve this question, since we dont know where to buy and sell and hence we will have to take up an
// exhaustive approach which would result in an exponential Time complexity, in order to optimize it we can use DP 0/1 approach
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];

        // 1 element case
        dp[0][0] = -prices[0];  // buy
        dp[0][1] = 0;           // sell

        // 2 elements case
        // need to handle 1 index case before for loop since the formula is different
        dp[1][0] = Math.max(dp[0][0], -prices[1]);       // buy
        dp[1][1] = Math.max(0, prices[1] + dp[0][0]);    // sell

        // n elements case
        for (int i=2; i<n; i++) {
            //                  0 case      1 case
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1] - prices[i]);  //buy
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);  //sell
        }

        // the final prize will be at the last box
        return dp[n-1][1];
    }
}
