/*
309. Best Time to Buy and Sell Stock with Cooldown
Ran on leetcode: Yes
TC: O(n) SC: O(n)
We build our profit bottom up, at each point we have option to buy or sell, if we buy we can either skip and move to next index or buy and reduce it from our profit and if we sell we can either skip and move to next index or sell and add it to our profit.
*/
class Solution {

    Integer memo[][];

    public int maxProfit(int[] prices) {
        this.memo = new Integer[prices.length][2];
        return findMaxProfit(prices, 0, 0);
    }

    private int findMaxProfit(int[] prices, int idx, int status){
        
        if(idx >= prices.length){ // base case
            return 0;
        }

        if(this.memo[idx][status] != null){ // return if we have already solved the problem
            return this.memo[idx][status];
        }

        int result;

        if(status == 0){ // buy
            // We either skip and move to next index to buy or buy at the current index and reduce it from our profit
            result = Math.max( 
                findMaxProfit(prices, idx + 1, 0), // skip
                findMaxProfit(prices, idx + 1, 1) - prices[idx] // buy
                );
        } else { // sell
            // We either skip and move to next index to sell or sell at the current index and add it from our profit
            result = Math.max(
                findMaxProfit(prices, idx + 1, 1), // skip
                findMaxProfit(prices, idx + 2, 0) + prices[idx] // sell
            );
        }

        // store the result of the subproblem
        memo[idx][status] = result;

        return result;
    }
}