// Time: O(nk)
// Space: O(n)

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0){
            return 0;
        }
        
        if (k >= prices.length / 2){
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                if (prices[i] > prices[i-1]){
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }
        
        int [] buy = new int [k];
        int [] sell = new int [k];
        Arrays.fill(buy, prices[0]);
        buy[0] = prices[0];
        for(int i = 1; i < prices.length; i++){
            for(int j = 0; j < k; j++){
                if (j == 0){
                    buy[j] = Math.min(buy[j], prices[i]);
                    sell[j] = Math.max(sell[j],prices[i] - buy[j]); 
                }else{
                    buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                    sell[j] = Math.max(sell[j],prices[i] - buy[j]);
                }
            }
        }
        
        return sell[k-1];
        
    }
}
