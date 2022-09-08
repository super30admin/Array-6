// Time Complexity : O(nk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 using consolidated profits array
    public static int maxProfit(int k, int[] prices) {
        // null case
        if (prices == null || prices.length == 0)
            ;

        int n = prices.length;
        // optimization
        // if k is greater then half of the
        // n we can buy and sell at each day
        int result = 0;
        if (k >= n / 2) {
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        // else we take consolidated profits
        int[] buy = new int[k + 1];
        // intialize buy with 9999 as for first
        // iteration we are counting min values
        Arrays.fill(buy, 9999);
        buy[0] = prices[0];
        int[] sell = new int[k + 1];

        // go over all the days and
        // count max profit for each k's
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }

    public static void main(String[] args) {
        int[] prices = new int[] { 3, 2, 6, 5, 0, 3 };
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
}