/*
Buy and Sell Stock at Best Time
approach: we can see that max profit is when we buy at low and sell at max
time: O(n)
space: O(1)
 */
public class Problem1 {
    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0;

        for (int i=1;i<prices.length;i++) {
            max = Math.max(max, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
