// 188.
// approach - extend max profit possible with 2 transactions (atmost) - store the buy and sell values for each transactions in seperate arrays
// time - O(nk)
// space - O(n)
class Solution {
    public int maxProfit(int k, int[] prices) {
        //edge
        if(prices == null || prices.length == 0)
        {
            return 0;
        }
        
        //edge
        if(k >= prices.length / 2)
        {
            //# of transactions allowed is larger than possible # of transactions i.e. buy and sell at each pair 
            int profit = 0;
            for(int i = 0; i < prices.length - 1; i++)
            {
                //make a transaction at this pair as a positive profit is obtained
                if(prices[i] < prices[i + 1])
                {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }
        
        
        int[] buy = new int[k + 1]; //similar to buy1 and buy2
        int[] sell = new int[k + 1]; //similar to sell1 and sell2
        Arrays.fill(buy, Integer.MAX_VALUE); //initially buy variables are set to infinity
        
        for(int price : prices)
        {
            for(int i = 1; i <= k; i++)
            {
                //fill buy and sell arrays
                //effective price so far - current price - profit earned so far i.e. sell[i - 1]
                buy[i] = Math.min(buy[i], price - sell[i - 1]); 
                //sell at this price after buying at effective price tracked by buy[i]
                sell[i] = Math.max(sell[i], price - buy[i]); 
            }
        }
        
        return sell[k];
    }
}
