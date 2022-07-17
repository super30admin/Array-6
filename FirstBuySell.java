public class FirstBuySell {
    // Greedy approach
    // TC : O(n)
    // SC : O(1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int price : prices) {
            min = Math.min(min, price); // keep on updating the min value to maximize the profit
            max = Math.max(max, price - min); // keep on updating the max value based on the updated min value above
        }
        return max;
    }
}
