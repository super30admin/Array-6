// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// find the buy1 and sell1 same as the peak - vally approachm for buy2 = min of buy2 and curr-sell1, and for sell2 = max ( sell2, curr_value-buy2);
// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int[] prices) {
        int b1 = Integer.MAX_VALUE;
        int s1 = Math.max(0, prices[0]-b1);
        int b2 = Integer.MAX_VALUE;
        int s2 = Math.max(0, prices[0]-b2);
        for(int i  = 0; i < prices.length; i++){
            b1 = Math.min(b1, prices[i]);
            s1 = Math.max(s1, prices[i]-b1);
            b2 = Math.min(b2, prices[i]-s1);
            s2 = Math.max(s2, prices[i]-b2);
        }
        return s2;
    }
}