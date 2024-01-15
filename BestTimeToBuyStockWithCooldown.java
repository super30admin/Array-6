// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class BestTimeToBuyStockWithCooldown {
  public int maxProfit(int[] prices) {
    int[] maxPrices = new int[prices.length + 2];

    for (int i = prices.length - 1; i >= 0; i--) {
      int c1 = 0;
      // Case 1). buy and sell the stock
      for (int sell = i + 1; sell < prices.length; sell++) {
        int profit = (prices[sell] - prices[i]) + maxPrices[sell + 2];
        c1 = Math.max(profit, c1);
      }

      // Case 2). do no transaction with the stock p[i]
      int c2 = maxPrices[i + 1];

      // wrap up the two cases
      maxPrices[i] = Math.max(c1, c2);
    }
    return maxPrices[0];
  }
}