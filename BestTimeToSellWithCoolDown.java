// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will fill the first two entry to buy and sell arrays as there is cool down period 
// And we can't have multple txn till now
// Next we will maintain the the buy and sell arrays
// But would be max previous buy value if we ignore buying now
// Or it would be the profit we had by selling at the prev to prev position - the current buy price
// Selling amount profit would be the prev value if we ignore selling now or sum of currect buy and selling price
// Finally we will have the max profit value at last index of sell array and we will return it
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2)
            return 0;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(0, buy[1] + prices[1]);
        for(int i = 2; i < n; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i] + prices[i]);
        }
        return sell[n-1];
    }
}