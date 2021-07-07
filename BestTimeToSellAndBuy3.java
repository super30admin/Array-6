

// Time Complexity : O(N)
// Space Complexity : O(1)
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
*/ 


public class BestTimeToSellAndBuy3 {
    public int maxProfit(int[] prices) {
        int profit1 = 0,buy1  = Integer.MAX_VALUE ,buy2= Integer.MAX_VALUE,profit2 =0;
         
        for(int price : prices){
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1,price - buy1);
            buy2 = Math.min(buy2,price - profit1);
            profit2 = Math.max(profit2,price - buy2);
        }
         return profit2;
     }

     public static void main(String args[]){
        int prices[] = {3,3,5,0,0,3,1,4};

        BestTimeToSellAndBuy3 time = new BestTimeToSellAndBuy3();

        System.out.println(time.maxProfit(prices));
    }
}