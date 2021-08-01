/*121. Best Time to Buy and Sell Stoc
TC -> O(n)
SC */

class Solution {
    public int maxProfit(int[] prices) {
        // edge case
        if (prices.length == 0 || prices == null){
            return 0;
        }
        
        int minbuying_price = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0;i<prices.length;i++){
            minbuying_price  = Math.min(minbuying_price,prices[i]);
            maxprofit = Math.max(maxprofit,prices[i]-minbuying_price);
                
        }
        return maxprofit;
        
        
    }
}