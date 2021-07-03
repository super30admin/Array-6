//time complexity O(nk)
//space complexity O(k)

class Solution {
    public int maxProfit(int k, int[] prices) {
        int maxProfit = 0;
        if(k >= prices.length/2){
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i-1]){
                    maxProfit += prices[i] - prices[i-1];
                }
            }
            return maxProfit;
        }

        int [] buy = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int [] profit = new int[k+1];
        // Arrays.fill(profit, Integer.MIN_VALUE);
        for(int price: prices){
            for(int i = 1; i <= k; i++){
                buy[i] = Math.min(buy[i], price - profit[i-1]);
                profit[i] = Math.max(profit[i], price - buy[i]);
            }
        }
        return profit[k];
    }
}
