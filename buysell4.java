// time complex : O(n*n*k)
// space complex : O(n*k)
// problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/


class Solution {
    int memo[][];
    int n;
    int prices[];
    public int maxProfit(int k, int[] prices) {
        this.n  = prices.length;
        this.prices = prices;
        this.memo = new int[k+1][n+1];
        for(int[] mem : memo)
            Arrays.fill(mem, -1);
        return helper(k,0);
    }

    private int helper(int k , int start){
        // base case
        if(k == 0 )
            return 0;
        if(start >= n)
            return 0;
        // logic
        int result = 0;
        int currMax = 0;
        for(int i = start+1; i<n ; i++){
            currMax = Math.max(currMax, prices[i] - prices[start]);
            memo[k-1][i+1] = memo[k-1][i+1] == -1? helper(k-1, i+1) : memo[k-1][i+1];
            result = Math.max(result, currMax + memo[k-1][i+1]);
        }
        memo[k][start+1] = memo[k][start+1] == -1? helper(k, start+1) : memo[k][start+1];
        result = Math.max(result, memo[k][start+1]);
        return result;
    }
}
