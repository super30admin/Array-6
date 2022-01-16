//Time complexity:- O(n).
//space complexity:- O(1).

class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int profit=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            buy=Math.min(buy,prices[i]);// for maximum profit minimizing buy price.
           int calculatedprofit=prices[i]-buy;
            profit=Math.max(profit,calculatedprofit);
        }
        return profit;
    }
}