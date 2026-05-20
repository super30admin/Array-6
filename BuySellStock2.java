/**
 * Uses recursion + memoization with two states: buy state (can buy) and sell state (holding stock).
 * At each index, we either skip the transaction or perform buy/sell to maximize profit.
 * Time Complexity: O(n) since each (index, state) is computed once. Space Complexity: O(n) for memoization + recursion stack.
 */
public class BuySellStock2 {

    class Solution {

        Integer[][] memo;

        public int maxProfit(int[] prices) {
            int n = prices.length;
            this.memo = new Integer[n][2];

            return helper(prices, 0, 0);
        }

        // 0 = buy state, 1 = sell state
        private int helper(int[] prices, int idx, int state) {

            if (idx >= prices.length)
                return 0;

            if (memo[idx][state] != null)
                return memo[idx][state];

            int re = 0;

            if (state == 0) { // buy state

                // skip buy OR buy stock
                re = Math.max(
                        helper(prices, idx + 1, 0),
                        helper(prices, idx + 1, 1) - prices[idx]);

            } else { // sell state

                // skip sell OR sell stock
                re = Math.max(
                        helper(prices, idx + 1, 1),
                        helper(prices, idx + 2, 0) + prices[idx]);
            }

            memo[idx][state] = re;
            return re;
        }
    }
}
