/**
 * Uses DFS + memoization DP where state represents current day, buy/sell state,
 * and remaining transactions. At each step, we either skip the day or perform
 * the buy/sell action that maximizes profit.
 *
 * Time Complexity: O(n * 2 * k) = O(nk)
 * Space Complexity: O(n * 2 * k) + O(n recursion stack) = O(nk)
 */
public class BuySellStock4 {
    Integer[][][] memo;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        this.memo = new Integer[n][2][k + 1];
        return helper(prices, 0, 0, k);
    }

    private int helper(int[] prices, int i, int state, int k) {
        // Base cases
        if (i >= prices.length || k == 0)
            return 0;

        if (memo[i][state][k] != null)
            return memo[i][state][k];

        int result = 0;

        if (state == 0) {
            result = Math.max(helper(prices, i + 1, 0, k),
                    helper(prices, i + 1, 1, k) - prices[i]);
        } else {
            result = Math.max(helper(prices, i + 1, 1, k),
                    helper(prices, i + 1, 0, k - 1) + prices[i]);
        }

        memo[i][state][k] = result;
        return result;
    }
}
