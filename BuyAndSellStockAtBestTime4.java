// Time Complexity : O(n*k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Approach : Similar approach to what we used in buying and sell for atmost 2 transactions, but as k transactions are involved here, we maintain the best ones at each transaction
// in a buy and sell array and return the kth value, which gives the maximum possible profit for k transactions.

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k+1]; //buy array for k transactions
        int[] sell = new int[k+1]; //sell array for k transactions
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int i = 0; i<prices.length;i++){
            for(int j=1; j<=k;j++){
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]); //decision to hold previous buy or  sell & buy
                sell[j] = Math.max(sell[j], prices[i] - buy[j]); //decision to not hold or sell at current profit
            }
        }
        return sell[k]; //max possible profit
    }
}