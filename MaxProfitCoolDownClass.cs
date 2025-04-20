public class Solution {
    // SC => O(n)
    // TC => O(n)
    public int MaxProfit(int[] prices) {
        if(prices == null || prices.Length <= 1){
            return 0;
        }

        int n = prices.Length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;

        buy[1] = Math.Max(buy[0], 0 - prices[1]);
        sell[1] = Math.Max(sell[0], prices[1] + buy[0]);

        for(int i = 2; i< n; i++){
            buy[i] = Math.Max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.Max(sell[i-1], prices[i] + buy[i-1]);
        }
        return sell[n-1];
    }
    //TC => O(2^n)
    //SC => O(n)
    public int MaxProfit1(int[] prices) {
        if(prices == null || prices.Length == 0){
            return 0;
        }

        return Recurse(prices, 0, -1, 0);
    }

    public int Recurse(int[] prices, int index, int prevBuy, int profit){
        //base
         if(index >= prices.Length){
            return profit;
         }   
        //logic

        if(prevBuy == -1){
            return Math.Max(Recurse(prices, index + 1, prevBuy, profit), Recurse(prices, index + 1, prices[index], profit));
        }
        else{
            return Math.Max(Recurse(prices, index + 1, prevBuy, profit), Recurse(prices, index + 2, -1, profit + prices[index] - prevBuy));
        }
    }
}