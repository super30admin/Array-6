// Time Complexity : O(n)
// Space Complexity : O(n*2) = O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We see a pattern of repeated sub problem, so we perform dp. At each index we have an option to dont buy, buy, sell, dont sell. With the help of tabulation dp matrix,
// we need to buy at a index if the sell performed a day ago and current gives max effective amount than the previous buy, considering the cooldown. For sell, we consider
// existing previous profit vs the if we sell now. The end of the matrix gives the effective profit as we have taken care of cooldown period while buying itself. This solution
// can be further optimized to make space as O(1) by using variables for storing buys and sells.

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0]; //initial buy
        dp[1][0] = Math.max(-prices[0], -prices[1]); //second buy
        dp[1][1] = Math.max(dp[0][1], prices[1] + dp[0][0]); //second sell
        for(int i = 2; i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1] - prices[i]); //max between previous buy effective value and previous profit from 1 day gap-current buy
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]); //max between previous profit and current selling profit of previous buy
        }
        return dp[n-1][1]; //effective profit
    }
}