
/*
Time complexity :O(N)
Space complexity:O(1)

worked on LC : YES
*/
class Solution {
    public int maxProfit2(int[] prices) {
        // find out what you will get if you are doing only one transaction
        // try to add first transaction into buying point for 2nd transaction, so finally
        // 2nd transaction profit will combine overall profit of 2 transaction
        if(prices == null  || prices.length == 0) return 0;
        
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        
        int profit1 = 0;
        int profit2 = 0;
        
        for(int price: prices) {
            
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            
            buy2 = Math.min(price - profit1, buy2);
            profit2 = Math.max(profit2, price-buy2);
        }
        
        return profit2;
    }
    
   
