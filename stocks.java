class Solution {
    public int maxProfit(int[] prices) 
    {
        int min=0,cost=0,profit=0, max=0;
        min=prices[0];
        for(int i=1; i<prices.length; i++)
        {  
            cost= prices[i]-min;                 // calculating cost like 1-7
            profit= Math.max(profit,cost);      // checking the highest profit
            min=Math.min(min,prices[i]);       // keeping track of min value

        }
       
        return profit;
    }
}