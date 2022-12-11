class Solution {
    //tc-n^2 sc-o(1)
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++)
        {
         for(int j=i;j<prices.length;j++)
         {
             max = Math.max(max, prices[j]-prices[i]);
         }
        }
        return max;
    }
}

class Solution {
    //tc-o(n) sc-o(1)
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
         min = Math.min(min, prices[i]);
         max = Math.max(max,prices[i]-min);
        }
        return max;
    }
}