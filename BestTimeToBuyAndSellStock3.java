/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Utilize the profits made from first transaction to buy profits from second transaction
 */

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int p: prices) {
            buy1 = Math.min(buy1, p);
            sell1 = Math.max(sell1, p - buy1);

            buy2 = Math.min(buy2, p - sell1);
            sell2 = Math.max(sell2, p - buy2);
        }

        return sell2;
    }
    public static void main(String[] args) {
        // Your code here
    }
}