// Time: O(n)
// Space: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int i = 1;
        int profit = 0;
        while (i < prices.length){
            mini = Math.min(mini, prices[i]);
            profit = Math.max(profit, prices[i]-mini);
            i++;
        }
        return profit;
    }
}
