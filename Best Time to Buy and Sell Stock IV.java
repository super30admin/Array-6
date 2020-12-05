//Time Complexity=O(n)
//Space Complexity-O(k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[]buy=new int[k+1];
        Arrays.fill(buy,Integer.MAX_VALUE);
        int[]profit=new int[k+1];
        for(int price:prices)
        {
            for(int i=1;i<=k;i++)
            {
                buy[i]=Math.min(buy[i],price-profit[i-1]);
                profit[i]=Math.max(profit[i],price-buy[i]);
            }
        }
        return profit[k];
    }
}