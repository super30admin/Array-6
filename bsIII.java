//TC: O(n*k): memoized states over (day i, state∈{0,1}, remaining k) each solved once with O(1) transitions; for k=2 ⇒ O(n).
//SC: O(n*k): memo table of size n×2×(k+1); plus recursion stack O(n) (overall O(n + n*k) ≈ O(n*k)).

//Define helper(i, state, k): max profit from day i with state 0=can buy, 1=holding, and up to k sells left (transactions).
//Transition: if state==0 → max(skip, buy = helper(i+1,1,k) - prices[i]); if state==1 → max(hold, sell = helper(i+1,0,k-1) + prices[i]); memoize.
//Answer is helper(0, 0, 2) using top-down DP with memoization to avoid recomputation.

class Solution {
    Integer[][][] memo; 

    public int maxProfit(int[] prices) {
        int k = 2;
        int n = prices.length;
        this.memo = new Integer[n][2][k + 1]; 
        return helper(prices, 0, 0, k); 
    }

    private int helper(int[] prices, int i, int state, int k) {
        // Base cases
        if (i >= prices.length || k == 0) return 0; 

        if (memo[i][state][k] != null) return memo[i][state][k]; 

        int result = 0;

        if(state == 0){
            result = Math.max(helper(prices, i + 1, 0, k), 
                    helper(prices, i + 1, 1, k) - prices[i]);
        } 
        else{
            result = Math.max(helper(prices, i + 1, 1, k), 
                    helper(prices, i + 1, 0, k - 1) + prices[i]);
        }

        memo[i][state][k] = result;
        return result;
    }
}
