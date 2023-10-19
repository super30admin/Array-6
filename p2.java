// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int buy2 = buy1;
        int sell1 = 0;
        int sell2 = 0;
        //go through all the prices
        for(int i=1; i<prices.length; i++){
            //minimum amount at which we can buy
            buy1 = Math.min(buy1, prices[i]);
            //max profit
            sell1 = Math.max(sell1, prices[i] - buy1);
            //min amount to buy for second time considering the first profit
            buy2 = Math.min(buy2, prices[i] - sell1);
            //max profit I can get
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
}