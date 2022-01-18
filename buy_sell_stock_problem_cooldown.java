//T.C. O(N)
//S.C. O(1)
class Solution {
    public int maxProfit(int[] prices) {
       //int n = prices.length;
        
        int buy1 = Integer.MAX_VALUE; 
        int sell1 = 0;
        for(int i = 0; i< prices.length; i++){
            
            int price = prices[i];
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price-buy1);
            
                
            }
        
        return sell1;
    }
}