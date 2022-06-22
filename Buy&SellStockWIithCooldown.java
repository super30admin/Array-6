//TC : O(N)
//SC : O(N)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)    return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], 0 - prices[1]);
        //sell[0] = 0 by default
        sell[1] = Math.max(0, buy[0] + prices[1]);
        
        for(int i = 2; i< prices.length; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] );
        }
        
        return Math.max(buy[prices.length - 1], sell[prices.length - 1]);
    }
}



/*
//TC : 2^n or 4^n
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)    return 0;
        
        return helper(prices, 0, -1, 0);
    }
    public int helper(int[] prices, int index, int isBought, int profit){
        if(index >= prices.length)  return profit;
        
        
        // if(isBought == -1){
     //   //     return Math.max(  helper(prices, index + 1, isBought, profit), /* Don't buy the stock*/
        //                       helper(prices, index + 1, prices[index], profit) /*  buy the stock */ );
        // } else{
        //     return Math.max(  helper(prices, index + 1, isBought, profit), /* Don't Sell the stock*/ +
        //                       helper(prices, index + 2, -1, profit + prices[index] - isBought) /*  Sell the stock */ );
        // }
        
//    }
//}

//*/
