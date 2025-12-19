/*
188. Best Time to Buy and Sell Stock IV
Ran on leetcode: Yes
TC: O(n) SC: O(n)
At each idx in prices we have k transactions of buy and sell, calculate the profit from the first transaction and use it in next transaction and so on k times
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1]; // k + 1 size array to accomodate first buy

        Arrays.fill(buy, prices[0]);

        for(int i = 1; i < prices.length; i++){ // At each prices array
            for(int j = 1; j <= k; j++){ // Number of states, if we have k transactions there will be 2 * k states of buy and sell
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]); // Cumulative buy of all the transactions
                sell[j] = Math.max(sell[j], prices[i] - buy[j]); // Cumulative profit from all the traansactions
            }
        }

        return sell[k]; // Cumulative profti
    }
}