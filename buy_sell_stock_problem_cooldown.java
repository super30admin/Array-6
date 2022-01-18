//TC:O(N)
//SC:O(N)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)return 0;
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];
        buy[1] = prices[0];
        for(int i = 2; i<= prices.length; i++)
        {
            int price = prices[i-1];
            buy[i] = Math.min(buy[i-1], price - sell[i-2]);
            sell[i] = Math.max(sell[i-1], price- buy[i]);
        }
        
        return sell[prices.length];
    }
}