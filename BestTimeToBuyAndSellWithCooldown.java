/*
Time Complexity: O(N), N is the size of the prices array
Space Complexity: O(N), size of the buy and sell array
Run on leetcode: yes
Any difficulties: No

Approach:
Attempted once discussed in the class
 */
public class BestTimeToBuyAndSellWithCooldown {
    public static int maxProfitWithCooldown(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0]; // Already bought making it negative
        buy[1] = Math.max(-prices[0], -prices[1]);

        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
    public static void main(String[] args){
        System.out.println("Maximum Profit in cooldown period: "+ maxProfitWithCooldown(new int[]{1,2,3,0,2}));
        }
}
