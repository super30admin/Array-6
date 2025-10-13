/**
 * Brute Force
 * O(n2) Time Complexity
 * O(1) Space Complexity
 */
class BestTimeToBuyStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit1=0, profit2=0;
        //Single transaction
        int profit = helper(prices, 0, n);
        int maxProfit = 0;

        //Two Transactions
        for(int i=0; i<n; i++){
                profit1 = helper(prices, 0, i);
                profit2 = helper(prices, i, n);
                maxProfit = Math.max(maxProfit, profit1 + profit2);
            }
        return Math.max(profit, maxProfit);
    }

        public int helper(int[] prices, int low, int high){
            int min = Integer.MAX_VALUE;
            int profit = 0;

            for(int i=low; i<high; i++){
                min = Math.min(min, prices[i]);
                profit = Math.max(profit, prices[i]-min);
            }
            return profit;
    }
}

/*
 * Optimal
 * Using the profit obtained from transaction1 to buy in transaction 2.
 * buy1 = Math.min(buy1, prices[i]);
 * sell1 = Math.max(sell1, prices[i] - buy1);
 * 
 * buy2 = Math.min(buy2, prices[i] - sell1);
 * sell2 = Math.max(sell2, prices[i]-buy2);
 */

 class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // Assuming atmost 2 transactions
        // We consider 2 buys and 2 sells in making profit
        // Also, A 1 transaction might give us more profit than 2 transactions [1, 2, 3, 11]
        // To include a single transaction giving more profit than 2 transactions we can do
        // Use the sell1 to be leverage buy2 i.e. use the profit of transaction 1 to buy 2nd transaction.
        // This will keep single transaction becoming maximum handy.

        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = Integer.MIN_VALUE, sell2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i]-buy1);

            buy2 = Math.min(buy2, prices[i]- sell1);
            sell2 = Math.max(sell2, prices[i]- buy2);
        }
        return sell2;
    }
}