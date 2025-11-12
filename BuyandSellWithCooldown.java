
//TimeComplexity:O(n)
//SpaceComplexity:O(n)
//We use recursion with memoization to explore all buy and sell options at each day.
//If we buy, we move to the sell state; if we sell, we skip the next day due to cooldown.
//The memo table caches results for (day, state) to avoid recomputation.

class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.memo = new Integer[n][2];

        return helper(prices, 0, 0);
    }

    private int helper(int[] prices, int idx, int sellstate){ // 0 buy state, 1 sell state

        if(idx >= prices.length) return 0;

        if(memo[idx][sellstate] != null) return memo[idx][sellstate];

        int re = 0;

        if(sellstate == 0){ // buy state
            // dont buy  , buy
            re =  Math.max(helper(prices, idx+1, 0),
                            helper(prices, idx+1, 1) - prices[idx]);
        }else{ // sell state
            //dont sell, sell
            re = Math.max(helper(prices, idx+1, 1),
                            helper(prices, idx+2, 0) + prices[idx]);
        }

        memo[idx][sellstate] = re;
        return re;
    }
}