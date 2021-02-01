// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes

class SolutionThree
{
    public int maxProfit(int k, int[] prices)
    {
        if(prices==null||prices.length==0)
            return 0;

        int[] buy = new int[k+1];

        Arrays.fill(buy,Integer.MAX_VALUE);

        int[] sell = new int[k+1];

        for(int i=0;i<prices.length;i++)
        {
            for(int j=1;j<buy.length;j++)
            {
                buy[j] = Math.min(buy[j],prices[i]-sell[j-1]);

                sell[j] = Math.max(sell[j],prices[i]-buy[j]);
            }
        }

        return sell[k];
    }


}