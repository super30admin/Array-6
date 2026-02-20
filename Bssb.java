class Bssb {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maximumProfit = 0;
        for(int i = 1; i < prices.length; i++)
        {
            min = Math.min(min, prices[i]);
            maximumProfit = Math.max(maximumProfit, prices[i] - min);
        }
        return maximumProfit;
    }
}