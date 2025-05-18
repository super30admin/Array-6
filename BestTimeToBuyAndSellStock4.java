import java.util.Arrays;

/**
 * Time Complexity: O(nk)
 * Space Complexity: O(k)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Same as Best time to buy sell 3, since there are k most transactions,
 * we need to get buy and sell for all k transactions
 */

public class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] sell = new int[k];

        Arrays.fill(buy, Integer.MAX_VALUE);

        for(int p: prices) {
            int prevProfit = 0;
            for (int i = 0; i < k; i++) {
                buy[i] = Math.min(buy[i], p - prevProfit);
                sell[i] = Math.max(sell[i], p - buy[i]);
                prevProfit = sell[i];
            }
        }

        return sell[k - 1];
    }
    public static void main(String[] args) {
        // Your code here
    }
}