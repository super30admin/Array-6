// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We keep track of minimum price for the 1st buy and compute 1st profit by taking differnce of current price and
1st buy cost. For 2nd transaction, we use the 1st profit by adjusting the cost of 2nd buy.then we compute
profit of 2nd transaction which contributes to the total profit generated so far.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE, t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;

        for(int price : prices) {
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);

            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }
        return t2Profit;
    }
}