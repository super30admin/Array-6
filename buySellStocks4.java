// Time Complexity = O(nk), where n=no. of prices, and k=no. of transactions
// Space Complexity = O(k), for the buys and sells array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We maintain 2 sets of buy and sell, so that we track the 2 occurances of buy and sells, but we also make sure that we
// can skip the second buy and sell pair if we only have 1 transaction

// we want to minimize the buy1 price, so we check for a min value
// sell1 = maximum value between previous sell1, and by selling at the current price
// buy2 = (current price)-(profit from previous sale)
// sell 2 = formula similar to sell1 = max(sell2, current price-buy2)
// The above logic can continue for k values of buy and sell, so we put that logic in a for loop till k
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;

        int[] buys = new int[k];
        Arrays.fill(buys, Integer.MAX_VALUE);

        int[] sells = new int[k];

        for (int i=0; i<prices.length; i++) {
            for (int j=0; j<k; j++) {
                if (j == 0) {
                    buys[j] = Math.min(buys[j], prices[i]);
                }
                else {
                    buys[j] = Math.min(buys[j], prices[i] - sells[j-1]);
                }
                sells[j] = Math.max(sells[j], prices[i] - buys[j]);
            }
        }

        return sells[k-1];
    }
}