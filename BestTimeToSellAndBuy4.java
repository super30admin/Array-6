import java.util.Arrays;

// Time Complexity : O(Nk)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


/*
Over the iteration, we calculate 4 variables which correspond to the costs or the profits of each action respectively, as follows:

buy1: the minimal cost of buying the stock in transaction #1. 
The minimal cost to acquire a stock would be the minimal price value that we have seen so far at each step.

profit1: the maximal profit of selling the stock in transaction #1. 
Actually, at the end of the iteration, this value would be the answer for the first problem in the series,
 i.e. Best Time to Buy and Sell Stock.

buy2: the minimal cost of buying the stock in transaction #2, while taking into account the profit gained from the previous transaction #1. 
One can consider this as the cost of reinvestment. Similar with t1_cost, we try to find the lowest price so far, 
which in addition would be partially compensated by the profits gained from the first transaction.

profit2: the maximal profit of selling the stock in transaction #2. 
With the help of buy2 as we prepared so far, we would find out the maximal profits with at most two transactions at each step.

Above solution works for 2 transactions.We can extend the same concept to K Transaction.
WE need to take care of Edge case where 1st buy has no previous sell and value of K is greater than half of total transactions;
  
*/

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