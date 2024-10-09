// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;

        for (int i = 0; i < n; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1); // calculating the profit of first transaction
            buy2 = Math.min(buy2, prices[i] - sell1); // combining the profit of first transaction along with buying of
                                                      // stock of second transaction
            sell2 = Math.max(sell2, prices[i] - buy2); // total profit of both transactions
        }

        return sell2;

    }
}