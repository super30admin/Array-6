/*
123. Best Time to Buy and Sell Stock III
Ran on leetcode: Yes
TC: O(n) SC: O(1)
At every point we can be in 4 states, we calculate minimum price we have seen so far, max profit from first transaction, buy for second transaction which uses the profit from first transaction and sell in second transaction which keeps the cumulative profit.
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        // At every point we can be in 4 states
        int buy1 = prices[0]; 
        int sell1 = 0; 
        int buy2 = prices[0]; 
        int sell2 = 0; 

        for(int i = 1; i < prices.length; i++){ 
            buy1 = Math.min(buy1, prices[i]); // Minimum price we have seen so far
            sell1 = Math.max(sell1, prices[i] - buy1); // First transaction to sell
            buy2 = Math.min(buy2, prices[i] - sell1); // Second buy which includes profit from first transaction
            sell2 = Math.max(sell2, prices[i] - buy2); // Cumulative profit of first transaction and second buy
        }

        return sell2;
    }
}