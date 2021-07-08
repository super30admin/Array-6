// Time Complexity : O(n) where n is the number of prices
// Space Complexity : O(1) in place 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Get the minimum cost to buy and max price to sell but you sould buy it first as you traverse
the array. For sell, calculate the profit by subtracting the current price - minimum cost price got till now and as you get max profit return it.
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;                                                        // Base Case
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];                                                                    // Get minimum cost price
            }
             if(prices[i]-min > profit){
                profit = prices[i]-min;                                                                         // Get Max profit by reducing min CP
            }
        }
        return profit;                                                                      // Return max profit
    }
}