public class BestTimeToBuyandSellII {
//  Time Complexity: O(n)
//  Space Complexity: O(n)
//We calculate the best profit possible from 0 to i (left side) using one transaction.
//Then we calculate the best profit from i to end (right side) using another transaction.
//We take the max sum of both profits at every i to get the final answer.
    public int maxProfit(int[] prices)
    {
        int n = prices.length;
        int[] leftprofit = new int[n];
        int[] rightprofit = new int[n];

        int min = prices[0];

        for(int i=1;i<n;i++)
        {
            min = Math.min(min,prices[i]);
            leftprofit[i] = Math.max(leftprofit[i-1], prices[i]-min);
        }

        int max = prices[n-1];

        for(int i=n-2;i>=0;i--)
        {
            max = Math.max(max, prices[i]);
            rightprofit[i] = Math.max(rightprofit[i+1],max-prices[i]);
        }

        int profit = 0;
        for(int i=0;i<n;i++)
        {
            profit = Math.max(profit, leftprofit[i]+rightprofit[i]);
        }
        return profit;
    }
}
