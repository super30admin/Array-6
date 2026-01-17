// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : To achieve the solution in a single pass, we track the lowest buy and calculate the max first profit with buy1 and sell1. Now,
// we need to consider first transaction's profit as well if we are calculating second transaction and total profit. So, we update the
// buy2 by subtracting it by profit earned in first transaction. Now, the profit that is in sell2 gives the total best profit from one/two transactions.

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int sell1 = 0;
        int buy2 = prices[0];
        int sell2 = 0;
        for(int i = 0; i< prices.length;i++){
            //buy1, sell1 for maximum profit possible in single transaction
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            //buy2, sell2 for maximum profit possible at the end of two transactions
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2; //total best maximum profit
    }
}