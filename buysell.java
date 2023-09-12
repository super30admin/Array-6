// time complexity : O(n)
// space complexity : O(1)
// problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int result = 0;
        for(int i = 1 ; i<prices.length ; i++){
            if(prices[i]<prices[start])
                start = i;
            else
                result = Math.max(result, prices[i] - prices[start]);
        }
        return result;
    }
}
