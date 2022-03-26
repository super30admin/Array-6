// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We maintain 2 sets of buy and sell, so that we track the 2 occurances of buy and sells,
// but we also make sure that we can skip the second buy and sell pair if we only have 1 transaction

// we want to minimize the buy1 price, so we check for a min value
// sell1 = maximum value between previous sell1, and by selling at the current price
// buy2 = (current price)-(profit from previous sale)
// sell 2 = formula similar to sell1, max(sell2, current price-buy2)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy1 = prices[0], sell1 = 0;
        int buy2 = prices[0], sell2 = 0;

        for (int i=1; i<prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i]-buy1);

            buy2 = Math.min(buy2, prices[i]-sell1);
            sell2 = Math.max(sell2, prices[i]-buy2);
        }

        return sell2;
    }
}