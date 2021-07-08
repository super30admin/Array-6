// Time Complexity : O(n) where n is the number of prices
// Space Complexity : O(1) in place 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Merging  the two transactions with effective price
/* Your code here along with comments explaining your approach: Get the min Cost price as buy1. Get the max selling price as profit earned by reducing
buy1 from current price. The profit earned will contribute to buy2's cost price since you already have some earned profit to buy second time. Calculate
second profit by reducing current price - min cost price (effective price) till now.
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int buy1= Integer.MAX_VALUE, buy2= Integer.MAX_VALUE, sell1 = 0, sell2 = 0;
        for(int i = 0; i < prices.length; i++){
            buy1 = Math.min(buy1, prices[i]);                                                           // Min cost to buy stock
            sell1 = Math.max(sell1, prices[i] - buy1);                                                  // Max sell price
            buy2 =  Math.min(buy2, prices[i] - sell1);                                                  // Effective price by profit contribution
            sell2 = Math.max(sell2, prices[i] - buy2);                                              // Max sell price /earned profit
        }
        return sell2;                                                                               // Max profit
    }
}