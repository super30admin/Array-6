// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We track the minimum effective buy price using buy[j] for each transaction. Thereby, we compute the best profit
achieved for j sells using buy[j] and current price in sell[j]. The total profit for k transactions
would be available/accumulated in the sell[k]
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, prices[0]);

        for(int i = 1 ; i < n ; i++) {
            for(int j = 1 ; j <= k ; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
}