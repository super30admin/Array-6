// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
class SolutionOne {
    public int maxProfit(int[] prices)
    {

        if(prices==null || prices.length ==0)
            return 0;

        int min = prices[0];

        int profit = 0;

        //Find the minium price then find maximum difference between them
        for(int price:prices)
        {
            min = Math.min(min,price);

            profit =  Math.max(profit,price-min);
        }


        return profit;
    }
}