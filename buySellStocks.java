// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxprofit = 0;
        int min = prices[0];

        // itterate over the prices array and update maxprofit by checking the (price on the current day)-(min price in the past)
        for (int i=1; i<prices.length; i++) {
            maxprofit = Math.max(maxprofit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        return maxprofit;
    }
}