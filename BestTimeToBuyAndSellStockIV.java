//time: O(NK)| Space: O(K) not if K> N/2

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k==0) return 0;
        if(k>=prices.length/2) {
            // we pick every transaction, buy on day1 sell on day2, buy again on day2, sell on day3, and so on
            // if and only if tomorrow's stock price is greater than today's
            int profit = 0;
            for(int i=1;i<prices.length;i++){
                if(prices[i] > prices[i-1]) profit += prices[i]-prices[i-1];
            }
            return profit;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int j=0;j<prices.length;j++) {
            for(int i=0;i<k;i++) {
                buy[i] = Math.min(buy[i], i==0 ? prices[j] : prices[j]-sell[i-1]);
                sell[i] = Math.max(sell[i], prices[j]-buy[i]);
            }
        }
        return sell[k-1];
    }
}