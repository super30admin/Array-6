// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = prices[0];
        if(prices.length > 1){
            buy[1] = Math.min(buy[0], prices[1]);
            sell[1] = prices[1]-buy[1];
        }
        
        for(int i=2; i<prices.length; i++){
            buy[i] = Math.min(buy[i-1], prices[i]-sell[i-2]);
            sell[i] = Math.max(sell[i-1], prices[i]-buy[i]);
        }

        return sell[prices.length-1];
    }
}