//TC: O(N)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){
            if(minPrice > prices[i])
                minPrice = prices[i];
            else if(maxProfit < prices[i] - minPrice)
            {
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;
    }
}