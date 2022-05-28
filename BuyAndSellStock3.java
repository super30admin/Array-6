// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The idea is same as best time to buy stock 1. Instead we are have 2 transactions
// Our buy1 would be min so far, and buy2 would be after 1st transaction as cur - profit1
// This can go negative as if there was just 1 txn
// And when we have profit2 which is max of cur-buy2. It will have the max profit of combined
// 2 transactions. Finally we will return the profit2
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0; 
        for(int x: prices){
            buy1 = Math.min(buy1, x);
            profit1 = Math.max(profit1, x - buy1);
            buy2 = Math.min(buy2, x - profit1);
            profit2 = Math.max(profit2, x - buy2);
        }
        return profit2;
    }
}