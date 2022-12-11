class Solution {
    //tc-nk
    //sc-o(k)
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int[] sell = new int[k+1];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=1;j<=k;j++)
            {
                //buy2 = Math.min(buy2,prices[i]-sell1);
           // sell2 = Math.max(sell2, prices[i] -buy2);
                buy[j] = Math.min(buy[j],prices[i]-sell[j-1]);
                sell[j] = Math.max(sell[j],prices[i]-buy[j]);
            }
        }
        return sell[k];
    }
}