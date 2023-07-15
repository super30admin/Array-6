// Approach: One Pass, maintain minPrice and maxProfit on every iteration
// Time: O(n)
// Space: O(1)

class BestTimeToBuyAndSellStock_1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }
}