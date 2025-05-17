/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Try all possible ways and tabulate
 */

public class BestTimeToBuyAndSellStockWithCooldown {
    // -------- Linear space ----------
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int index = n - 1; index >= 0; index--) {
            dp[index][1] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);
            dp[index][0] = Math.max(prices[index] + dp[index + 2][1], dp[index + 1][0]);
        }
        return dp[0][1];
    }

    // -------- Constant space ----------
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];
        int[] curr = new int[2];
        for (int index = n - 1; index >= 0; index--) {
            curr[1] = Math.max(-prices[index] + front1[0], front1[1]);
            curr[0] = Math.max(prices[index] + front2[1], front1[0]);
            front2[0] = front1[0];
            front2[1] = front1[1];
            front1[0] = curr[0];
            front1[1] = curr[1];
        }
        return curr[1];
    }
    public static void main(String[] args) {
        // Your code here
    }
}