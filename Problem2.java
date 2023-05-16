/*
Buy and Sell Stock at Best Time III
approach: we can see at each day we have 3 options i.e. buy, sell or skip among which buy and sell depends on previous action taken
i.e. if prev action is buy, we can't buy again, if prev is sell we can't sell again, we can't sell without buying
which gives us a recursive solution
time: recursive: O(2^n) dp: O(n)
space: O(2^n) dp: O(1)
 */
public class Problem2 {
    int[][][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2][3];
        for (int i=0;i<n;i++) {
            for (int j=0;j<2;j++) {
                for (int k=0;k<3;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(prices, 0, 2, 0);
    }

    private int helper(int[] prices, int bought, int transLeft, int index) {
        //base
        if (transLeft == 0 || index == prices.length) {
            return 0;
        }
        if (dp[index][bought][transLeft] != -1) {
            return dp[index][bought][transLeft];
        }

        int skip, sell, buy, case1 = 0, case2 = 0;
        //logic
        if (bought == 1) {
            //chose to skip
            skip = helper(prices, bought, transLeft, index+1);

            //chose to sell
            sell = prices[index]+helper(prices, 0, transLeft - 1, index+1);
            case1 = Math.max(skip, sell);
            dp[index][bought][transLeft] = case1;
        } else {
            //chose to skip
            skip = helper(prices, bought, transLeft, index+1);

            //chose to buy
            buy = -prices[index]+helper(prices, 1, transLeft, index+1);
            case2 = Math.max(buy, skip);
            dp[index][bought][transLeft] = case2;
        }
        return dp[index][bought][transLeft];
    }

    public int maxProfitOptimized(int[] prices) {
        int buy1 = prices[0], buy2 = prices[0], sell1 = 0, sell2 = 0;

        for (int i=0;i<prices.length;i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i]-buy1);
            buy2 = Math.min(buy2, prices[i]-sell1);
            sell2 = Math.max(sell2, prices[i]-buy2);
        }
        return Math.max(sell1, sell2);
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.maxProfit(new int[]{1,2,3,4,5}));
    }
}
