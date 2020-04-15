// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


/*
If we plot numbers on graph
The points of interest are the peaks and valleys in the given graph. 
We need to find the largest peak following the smallest valley. 
We can maintain two variables - min and profit corresponding to the smallest valley and maximum profit 
(maximum difference between selling price and minprice) obtained so far respectively.
*/ 

public class BestTimeToSellAndBuy1 {
    public int maxProfit(int[] prices) {
        int profit = 0,min = Integer.MAX_VALUE;
        for(int price : prices){
            min = Math.min(min,price);
            profit = Math.max(profit,price - min);
        }
        return profit;
    }


    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};

        BestTimeToSellAndBuy1 time = new BestTimeToSellAndBuy1();

        System.out.println(time.maxProfit(prices));
    }
}