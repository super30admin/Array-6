// Time Complexity : O(nk)
// Space Complexity : O(2k) - buy and sell arrays
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;

public class BestTimeToBuyAndSellStocks4 {

    public int maxProfit(int k, int[] prices) {
        if(k == 0) return 0;
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);

        for(int i = 0 ; i < prices.length; i++){
            for(int j = 0; j < k; j++){
                if(j == 0){
                    buy[j] = Math.min(buy[j], prices[i]);
                }else{
                    //effective price for kth transaction
                    buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                }
                //consolidated profit at kth transaction
                sell[j] = Math.max(sell[j], prices[i]- buy[j]);
            }
        }
        return sell[k-1];
    }
}
