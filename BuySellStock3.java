//TC : O(N)
//SC : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int sell1 = Math.max(0, prices[0] - buy1);
        int buy2 = prices[0] - sell1;
        int sell2 = Math.max(0, prices[0] - buy2);
        
        for(int i = 1; i< prices.length; i++){
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        
        return sell2;
    }
}
