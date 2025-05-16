/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Try all possible ways and tabulate
 */

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int index = n - 1; index >= 0; index--) {
            dp[index][1] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
            dp[index][0] = Math.max(prices[index] + dp[index + 2][1], dp[index + 1][0]);
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        // Your code here
    }
}