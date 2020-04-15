import java.util.Arrays;

// Time Complexity : O(Nk)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


public class BestTimeToSellAndBuy4 {
    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length / 2){
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        int buy[] = new int[k + 1];
        int profit[] = new int[k + 1];
        Arrays.fill(buy,Integer.MAX_VALUE);        
        for(int price : prices){
            for(int i =1; i <=k; i++){
                buy[i] = Math.min(buy[i],price - profit[i -1 ]);
                profit[i] = Math.max(profit[i], price -  buy[i]);
            }
        }
        return profit[k];
    }

    public static void main(String args[]){
        int prices[] = {2,4,2};
        int k = 2;
        BestTimeToSellAndBuy4 profit = new BestTimeToSellAndBuy4();
        System.out.println(profit.maxProfit(k, prices));
    }
}