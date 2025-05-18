/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Always try to find the new min if any and get the maximized profit in one pass
 */

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int p: prices) {
            if (p < min) {
                min = p;
            } else if (p - min > maxProfit) {
                maxProfit = p - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        // Your code here
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        int profit = obj.maxProfit(new int[] {7,1,3,5,7,16});
        System.out.println(profit);
        assert (profit == 15);
    }
}