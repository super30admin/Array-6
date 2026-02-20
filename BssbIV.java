import java.util.*;
class BssbIV {
    public int maxProfit(int k, int[] prices) {
        int result = 0;
        int n = prices.length;
        if(k >= n/2) 
        {
            // same as buy and sell stock II problem solution
            for(int i = 0; i < n - 1; i++)
            {
                if(prices[i+1] > prices[i])
                {
                    result += prices[i+1] - prices[i];
                }
            }
            return result;
        }

        //else use same formulas from '123. Best Time to Buy and Sell Stock III'
        // loop each prices for k times/transactions
        // use array of k to store each values of buy and sell of kth transactiom - space O(1) == 100 + 100
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];

        // fill buy array with prices[0] - considering it as min buy
        Arrays.fill(buy, prices[0]);

        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j <= k; j++)
            {
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
}