//Time complexity:- O(N).
//Space complexity:- O(2n).

class Solution {
    public int maxProfit(int k, int[] prices) {
       int[] buy=new int[k+1];
       int[] profit=new int[k+1];
        Arrays.fill(buy,Integer.MAX_VALUE);
        for(int price:prices){
            for(int i=1;i<=k;i++){
                buy[i]=Math.min(buy[i],price-profit[i-1]);
                profit[i]=Math.max(profit[i],price-buy[i]); //similar to best buy and sell stock 3 but as here k transactions are there we will use array of size k+1 and same idea which we will offset profit of before transaction for next buy.
            }
        }
        return profit[k];
        
    }
}