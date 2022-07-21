//TC:O(nk)
//SC:O(k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k==0) return 0;

        int[] buy = new int[k];
        Arrays.fill(buy,Integer.MAX_VALUE);
        int[] sell = new int[k];

        for(int price : prices){
            for(int i=0;i<k;i++)
            {
                if(i==0){
                    buy[i] = Math.min(buy[i],price);
                }
                else
                    buy[i] = Math.min(buy[i],price-sell[i-1]);

                sell[i] = Math.max(sell[i],price-buy[i]);
            }
        }

        return sell[k-1];
    }
}