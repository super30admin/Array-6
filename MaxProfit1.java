//Time Complexity O(n)
//Space Complexity O(1)
class MaxProfit1 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++) {
            int curr = prices[i];
            min = Math.min(min, curr);
            profit = Math.max(profit, curr - min);
        }
        return profit;
    }
}
